package org.great.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

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
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	/*
	 * 上传
	 */
	@RequestMapping(value="/upload.action",method=RequestMethod.POST)
	public ModelAndView  fileUpload(@RequestParam MultipartFile fileact) throws IllegalStateException, IOException {
		String filename = fileact.getOriginalFilename();
		System.out.println("获取到的文件名："+filename);
		String root = request.getServletContext().getRealPath("/upload");
		System.out.println(root);
		fileact.transferTo(new File(root+"/"+filename));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("back/success");
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

        //public ResponseEntity（T  body，
        //                       MultiValueMap < String，String > headers，
        //                       HttpStatus  statusCode）
        //HttpEntity使用给定的正文，标题和状态代码创建一个新的。
        //参数：
        //body - 实体机构
        //headers - 实体头
        //statusCode - 状态码
    }

}
