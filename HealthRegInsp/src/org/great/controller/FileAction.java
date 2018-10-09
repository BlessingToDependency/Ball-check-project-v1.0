package org.great.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.great.bean.PerguirelaBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.biz.AdminBiz;
import org.great.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*
 * 用户下载模板
 */
@Controller
@RequestMapping("fileAction")
public class FileAction {
	
	@Resource
	private StaffBean staffBean;
	private List<StaffBean> userList;
	private int pageCountAll=1;//总页数
	@Resource
	private UserBiz userBizImp;//前台用户接口
	@Resource
	private AdminBiz adminBizImp;//后台接口
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	ModelAndView mav = new ModelAndView();

	
	/*
	 * 生成excel并导出
	 */
	@RequestMapping("/exportExcel.action")
	@ResponseBody
	public void exportExcel(String staffName,Long phone,String statTime,String stopTime,String partYear,Integer companyId,String myGuChId) throws Exception{
		Date now = new Date();
		InputStream fin = null;
		ServletOutputStream out = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowdate = df.format(now);
        String root = request.getRealPath("/upload");// 设置文件上传路径
        System.out.println("路径：" + root);
        System.out.println("时间：" + nowdate);
        String fileName = "人员体检名单" + nowdate + ".xls";
        fileName = new String(fileName.getBytes(), "ISO8859-1");
		File file = new File(root + fileName);
        
		
        // 打开文件
//        File file = new File("D:\\"+"人员体检名单"+nowdate + ".xls");
        WritableWorkbook book = Workbook.createWorkbook(file);
        
        String fileNick = "人员体检名单"+nowdate + ".xls";
        System.out.println("book="+book);
        System.out.println(fileNick);
        
        
        // 生成名为"第一页"的工作表，参数0表示这是第一
        WritableSheet sheet = book.createSheet("第一页", 0);

        // 设置字体为宋体,16号字,加粗,颜色为黑色
        WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12, WritableFont.BOLD);
        font1.setColour(Colour.BLACK);
        WritableCellFormat format1 = new WritableCellFormat(font1);
        format1.setAlignment(jxl.format.Alignment.CENTRE);
        format1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

        Label labelA = new Label(0, 0, "序号", format1);
        Label labelB = new Label(1, 0, "姓名", format1);
        Label labelC = new Label(2, 0, "性别", format1);
        Label labelD = new Label(3, 0, "年龄", format1);
        Label labelE = new Label(4, 0, "身份证号", format1);
        Label labelF = new Label(5, 0, "联系电话", format1);
        Label labelG = new Label(6, 0, "公司名", format1);

        // 将定义好的单元格添加到工作表中
        sheet.addCell(labelA);
        sheet.addCell(labelB);
        sheet.addCell(labelC);
        sheet.addCell(labelD);
        sheet.addCell(labelE);
        sheet.addCell(labelF);
        sheet.addCell(labelG);
        System.out.println("走到这------------------------------------"+companyId);
        //接收数据
        userList = adminBizImp.exportExcel( staffName, phone, statTime, stopTime, partYear,companyId,myGuChId);
		
        for (int i = 0; i < userList.size(); i++) {
            Label labelAi = new Label(0, i + 1, String.valueOf(userList.get(i).getStaffId()));
            Label labelBi = new Label(1, i + 1, userList.get(i).getStaffName());
            Label labelCi = new Label(2, i + 1, userList.get(i).getSex());
            Label labelDi = new Label(3, i + 1, String.valueOf(userList.get(i).getAge()));
            Label labelEi = new Label(4, i + 1, userList.get(i).getIdNum());
            Label labelFi = new Label(5, i + 1, String.valueOf(userList.get(i).getPhone()));
            Label labelGi = new Label(6, i + 1, userList.get(i).getUserBean().getCompany());
           
            System.out.println("----------------------"+labelAi.toString());
            
            sheet.addCell(labelAi);
            sheet.addCell(labelBi);
            sheet.addCell(labelCi);
            sheet.addCell(labelDi);
            sheet.addCell(labelEi);
            sheet.addCell(labelFi);
            sheet.addCell(labelGi);
        }  
     // 写入数据并关闭文件
        book.write();
        book.close();
        System.out.println("创建文件成功!");
        
        String str = "1";
        PrintWriter outt = response.getWriter();
        outt.print(str);
        
        fin = new FileInputStream(file);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/excel");
		response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

		
		out = response.getOutputStream();
		byte[] buffer = new byte[1024];// 缓冲区
		int bytesToRead = -1;
		// 通过循环将读入的Word文件的内容输出到浏览器中
		while ((bytesToRead = fin.read(buffer)) != -1) {
			out.write(buffer, 0, bytesToRead);
			out.flush();
		}
		
		System.out.println("写入完成");
		
		try {
			if (fin != null) {
				fin.close();
			}
			if (out != null) {
				out.close();
			}
//			if (file != null) {
//				file.delete(); // 删除临时文件
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * 生成excel后下载
	 */
	@RequestMapping("/downloadExcel.action")
	public ResponseEntity<byte[]> downloadExcel(HttpServletRequest request,String fileNick) throws Exception{

		ServletContext servletContext = request.getServletContext();
		String fileName=fileNick;
		String realPath = servletContext.getRealPath(fileName);//得到文件所在位置
		
		System.out.println("servletContext="+servletContext);
		System.out.println("realPath="+realPath);
		InputStream in=new FileInputStream(new File(realPath));//将该文件加入到输入流之中
		byte[] body=null;
		body=new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
		in.read(body);//读入到输入流里面

		fileName=new String(fileName.getBytes("gbk"),"iso8859-1");//防止中文乱码
		HttpHeaders headers=new HttpHeaders();//设置响应头
		headers.add("Content-Disposition", "attachment;filename="+fileName);
		HttpStatus statusCode = HttpStatus.OK;//设置响应吗
		ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;

	}
	
	/*
	 * 上传跳转页面
	 */
	@RequestMapping("/userUpload.action")
	public ModelAndView userUpload() {
		UserBean ub = (UserBean) request.getSession().getAttribute("userBean");
		if(null != ub) {
			mav.setViewName("FrontEnd/user_upload");
		}else {
			mav.setViewName("FrontEnd/user_login");
		}
		return mav;
	}
	
	/*
	 * 上传
	 */
	@RequestMapping(value="/fileUpload.action",method=RequestMethod.POST)
	public ModelAndView  fileUpload(@RequestParam MultipartFile fileact,PerguirelaBean perguirelaBean) throws IllegalStateException, Exception {
		//判断当前用户是否存在
		UserBean ub = (UserBean) request.getSession().getAttribute("userBean");
		if(null != ub) {
//			int companyId = userBean.getCompanyId();//公司id
			int id = ub.getCompanyId();//先写死
			String filename = fileact.getOriginalFilename();
			System.out.println("获取到的文件名："+filename);
			String root = request.getServletContext().getRealPath("/upload");
			System.out.println(root);  
			fileact.transferTo(new File(root+"/"+filename));

			//读取excel文件
			File f=new File(root+"/"+filename); 
			System.out.println(f);
			Workbook book=Workbook.getWorkbook(f);// 
			Sheet sheet=book.getSheet(0); //获得第一个工作表对象 
			int count = 0;//当前总上传的人数
			
			
			
			perguirelaBean.setBatchNum(1);//批次默认1
			UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
			//4插入关系表前，查询当前公司、当前年份下，是否有上传过人员
			PerguirelaBean pb = userBizImp.selectBatchNum(userBean.getCompanyId());
			if(null != pb) {
				//如果有值，则取出最大批次号，加1
				int maxCount = userBizImp.maxBatchNum(userBean.getCompanyId());
				perguirelaBean.setBatchNum(maxCount+1);//批次默认1
			}
			//定义标志位
			hasSomeWrong:
			for(int i=2;i<sheet.getRows();i++){ 
				
				StringBuffer strAppend = new StringBuffer();
				for(int j=1;j<sheet.getColumns();j++){ 
					Cell cell=sheet.getCell(j, i); //获得单元格 
					strAppend.append(cell.getContents()+"-");
				} 
				 System.out.println("xx="+strAppend);
				 //截取字段
				String[] strSplit = strAppend.toString().split("-");
				System.out.println(strSplit.toString());
				staffBean.setStaffName(strSplit[0]);
				staffBean.setAge(Integer.parseInt(strSplit[1]));
				staffBean.setSex(strSplit[2]);
				staffBean.setIdNum(strSplit[3]);
				staffBean.setPhone(Long.parseLong(strSplit[4]));
				staffBean.setCompanyId(id);
				System.out.println(staffBean.toString());
				
				
				
				//查询身份证号是否存在
				StaffBean sn = userBizImp.repeatNum(staffBean.getIdNum(),ub.getCompanyId());
				if(null != sn) {
					System.out.println("重复了"+staffBean.getIdNum());
					perguirelaBean.setBatchNum(1);//批次+1
					//插入员工导检单关系表；先查当前公司是否有插入过信息
				}else {
					//2再插入员工表
					userBizImp.addStaff(staffBean);
					
				}
				//3再改公司表开单状态
				
				
				perguirelaBean.setPartYear(staffBean.getIdNum());
				perguirelaBean.setCompanyId(userBean.getCompanyId());//公司id
				
				//插入员工导检单关系表
				userBizImp.addPerguirela(perguirelaBean);
				count=i;
			}
			System.out.println("count="+count);//上传人数
			//id;//当前公司id
			// 0; //预约收费
			 
			 //插入公司账单表；目前只插入公司id，人数为0，实际收费为0
			double actCharge = 0;
			Integer payState = 143;//支付状态:失败
			userBizImp.companyBill(id,actCharge,payState);
			
			return new ModelAndView("redirect:/fileAction/companyStaffList.action");
		}else {
			System.out.println("登陆去");
			mav.setViewName("FrontEnd/user_login");
		}
		return mav;
	}
	
	/*
	 * 查询当前公司下的员工
	 */
	@RequestMapping("/companyStaffList.action")
	public ModelAndView companyStaffList(StaffBean staffBean,Integer pages) {
		UserBean ub = (UserBean) request.getSession().getAttribute("userBean");
//		ub.getCompanyId();//当前公司id
//		companyId = ub.getCompanyId();
		//查询出当前公司的员工
		staffBean.setCompanyId(ub.getCompanyId());
		String page = String.valueOf(pages);
		if(page==null ||"null".equals(page)|| "".equals(page)||"0".equals(page)) {
			pages=1;
		}
		//分页
		int countAll=adminBizImp.userAdminCount(staffBean);//当前用户总个数
		if(countAll%10>0||countAll==0) {
			pageCountAll=countAll/10+1;
		}else {
			pageCountAll=countAll/10;
		}
		userList = adminBizImp.userAdmin(staffBean,pages);
		
		request.setAttribute("userList", userList);
		mav.addObject("pageCountAll", pageCountAll);//总页
		mav.addObject("pages", pages);//当前页
		
		mav.setViewName("FrontEnd/user_list");
		
		return mav;
	}
	
	
	/*
	 * 下载
	 */
	@RequestMapping("/fileDownLoad.action")
	public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request) throws Exception{

		ServletContext servletContext = request.getServletContext();
		String fileName="体检人员信息表.xls";
		String realPath = servletContext.getRealPath("/upload/"+fileName);//得到文件所在位置
		InputStream in=new FileInputStream(new File(realPath));//将该文件加入到输入流之中
		byte[] body=null;
		body=new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
		in.read(body);//读入到输入流里面

		fileName=new String(fileName.getBytes("gbk"),"iso8859-1");//防止中文乱码
		HttpHeaders headers=new HttpHeaders();//设置响应头
		headers.add("Content-Disposition", "attachment;filename="+fileName);
		HttpStatus statusCode = HttpStatus.OK;//设置响应吗
		ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;

	}

}
