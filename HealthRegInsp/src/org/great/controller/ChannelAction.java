/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.controller 
 * @author: wjx(wangj)   
 * @date: 2018年10月4日 上午11:26:52 
 */
package org.great.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.SetmealBean;
import org.great.bean.TblChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/** 
 * @ClassName: ChannelAction 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月4日 上午11:26:52  
 */
@Controller
@RequestMapping("Channel")
public class ChannelAction {

	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private  HttpSession session;
	@Autowired
	private ServletConfig config;
	@Autowired
	private ServletContext servletContext;	
	
	
	
	@RequestMapping("/showChannel.action")
	public String showChannel(Model model,TblChannel channel) {
		//接收套餐信息
		//List<SetmealBean> order = 
		
		return null;				
	}

	
}
