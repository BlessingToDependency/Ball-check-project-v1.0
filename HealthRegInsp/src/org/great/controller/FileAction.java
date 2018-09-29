package org.great.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.biz.AdminBiz;
import org.great.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
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
	 * 上传
	 */
	@RequestMapping(value="/fileUpload.action",method=RequestMethod.POST)
	public ModelAndView  fileUpload(@RequestParam MultipartFile fileact) throws IllegalStateException, Exception {
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
			
			//定义标志位
			hasSomeWrong:
			for(int i=3;i<sheet.getRows();i++){ 
				
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
				
				//1先查询身份证号是否存在
				StaffBean sn = userBizImp.repeatNum(staffBean.getIdNum());
				if(null != sn) {
					System.out.println("重复了"+staffBean.getIdNum());
					continue;
				}
				//2再插入员工表
				userBizImp.addStaff(staffBean);
				//3再改公司表开单状态
				
			}
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
	public ModelAndView companyStaffList(String staffName,Long phone,String statTime,String stopTime,String partYear,Integer companyId,Integer pages) {
		UserBean ub = (UserBean) request.getSession().getAttribute("userBean");
//		ub.getCompanyId();//当前公司id
		companyId = ub.getCompanyId();//先写死
		//查询出当前公司的员工
		String page = String.valueOf(pages);
		if(page==null ||"null".equals(page)|| "".equals(page)||"0".equals(page)) {
			pages=1;
		}
		//分页
		int countAll=adminBizImp.userAdminCount( staffName, phone, statTime, stopTime, partYear,companyId);//当前用户总个数
		if(countAll%10>0||countAll==0) {
			pageCountAll=countAll/10+1;
		}else {
			pageCountAll=countAll/10;
		}
		userList = adminBizImp.userAdmin( staffName, phone, statTime, stopTime, partYear,companyId,pages);
		
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
		String fileName="体检表.xls";
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
