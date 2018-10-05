package org.great.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.FinresultBean;
import org.great.biz.AdminBiz;
import org.great.biz.IMissInspBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
/*
 * 上传影像文件
 */
@Controller
@RequestMapping("/imageAction")
public class ImageExaminAction {
	
	@Resource
	private IMissInspBiz MissInspBizImp;
	@Resource
	private AdminBiz adminBizImp;

	@RequestMapping(value="/fileact.action", method=RequestMethod.POST)
	public ModelAndView fileact(HttpServletRequest request,FinresultBean finresultBean,@RequestParam("fileact") MultipartFile[] fileact){
		String guChId="CY-jx1803-2018-10-88-88";
		//判断file数组不能为空并且长度大于0
        if (fileact != null && fileact.length > 0) {
        	//循环获取file数组中得文件
        	for (int i = 0; i < fileact.length; i++) {
        		MultipartFile file = fileact[i];
        		String filename = file.getOriginalFilename();
        		//插入到细项结果表
        		adminBizImp.addFinresult(finresultBean);
        		System.out.println("获取到的文件名:" + filename);
        		try {
        			String root = request.getServletContext().getRealPath("/upload"+ "/" + guChId+ "/"); // 设置文件上传的路径
        			System.out.println(root);
        			File file1 = new File(root + "/" + filename);
        			file1.mkdirs();
                    file1.createNewFile();
        			file.transferTo(file1);
        			//插入到导检影视关系表
        			int res = MissInspBizImp.addImages(guChId, filename, finresultBean.getItemId());
        		} catch (IllegalStateException | IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	}
        }
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userinfo");
		return mav;
	}
	
}
