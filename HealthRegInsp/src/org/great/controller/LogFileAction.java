package org.great.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.LogBean;
import org.great.biz.ILogBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/*
 * 日志下载模板
 */
@Controller
@RequestMapping("logfileAction")
public class LogFileAction {
	@Resource
	private  ILogBiz  logBizImp;

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	ModelAndView mav = new ModelAndView();
	
	/*
	 * 生成excel并导出
	 */
	@RequestMapping("/exportLogExcel.action")
	public ModelAndView exportExcel() throws Exception{
		Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowdate = df.format(now);
        // 打开文件
        WritableWorkbook book = Workbook.createWorkbook(new File("日志"+nowdate + ".xls"));
        
        String fileNick = "日志"+nowdate + ".xls";
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
        Label labelB = new Label(1, 0, "操作时间", format1);
        Label labelC = new Label(2, 0, "操作人", format1);
        Label labelD = new Label(3, 0, "操作模块", format1);
        Label labelE = new Label(4, 0, "执行描述", format1);
        Label labelF = new Label(5, 0, "执行的方法", format1);
        Label labelG = new Label(6, 0, "IP地址", format1);
        Label labelH = new Label(7, 0, "响应时间", format1);

        // 将定义好的单元格添加到工作表中
        sheet.addCell(labelA);
        sheet.addCell(labelB);
        sheet.addCell(labelC);
        sheet.addCell(labelD);
        sheet.addCell(labelE);
        sheet.addCell(labelF);
        sheet.addCell(labelG);
        sheet.addCell(labelH);
        System.out.println("走到这------------------------------------");
        //接收数据
    
        LogBean logBean=new LogBean();
        List<LogBean> logLi=logBizImp.selectLogNu(logBean);
        for (int i = 0; i < logLi.size(); i++) {
        	
            Label labelAi = new Label(0, i + 1, String.valueOf(logLi.get(i).getLogId()));
            Label labelBi = new Label(1, i + 1, logLi.get(i).getTime());
            Label labelCi = new Label(2, i + 1, logLi.get(i).getName());
            Label labelDi = new Label(3, i + 1, logLi.get(i).getModule());
            Label labelEi = new Label(4, i + 1,logLi.get(i).getCommite() );
            Label labelFi = new Label(5, i + 1, logLi.get(i).getMethod());
            Label labelGi = new Label(6, i + 1,logLi.get(i).getIp());
            Label labelHi = new Label(7, i + 1,logLi.get(i).getResponseTime());
           
            System.out.println("----------------------"+labelAi.toString());
            
            sheet.addCell(labelAi);
            sheet.addCell(labelBi);
            sheet.addCell(labelCi);
            sheet.addCell(labelDi);
            sheet.addCell(labelEi);
            sheet.addCell(labelFi);
            sheet.addCell(labelGi);
            sheet.addCell(labelHi);
        }  
     // 写入数据并关闭文件
        book.write();
        book.close();
        System.out.println("创建文件成功!");
        ServletContext servletContext = request.getServletContext();
		String fileName=fileNick;
		String realPath = servletContext.getRealPath(fileName);//得到文件所在位置
		System.out.println("===================="+realPath);
     // return new ModelAndView("redirect:/logfileAction/downloadExcel.action?fileNick="+fileNick);
        return mav;
	}
	
	/*
	 * 生成excel后下载
	 */
	@RequestMapping("/downloadExcel.action")
	public ResponseEntity<byte[]> downloadExcel(HttpServletRequest request,String fileNick) throws Exception{
        System.out.println("nick=="+fileNick);
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
}
