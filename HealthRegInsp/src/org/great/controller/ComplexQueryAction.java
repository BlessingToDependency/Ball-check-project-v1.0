/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.controller 
 * @author: wjx(wangj)   
 * @date: 2018年10月7日 下午5:19:00 
 */
package org.great.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.StaffBean;
import org.great.biz.QueryBiz;
import org.great.biz.QueryBizImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @ClassName: ComplexQueryAction 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月7日 下午5:19:00  
 */
@Controller
@RequestMapping("/ComQuery")
public class ComplexQueryAction {

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
	@Resource
	private QueryBiz queryBizImp;
	
	/**
	 * 
	 * @Title: queryAll 
	 * @Description: 展示综合查询 
	 * @param model
	 * @param staffBean
	 * @return String
	 * @author: wjx(wangj)  
	 * @date 2018年10月8日上午12:42:45
	 */
	@RequestMapping("/queryAll.action")
	public  String queryAll(Model model,StaffBean staffBean) {
		if (null == staffBean.getCurrentpage()) {
			staffBean.setCurrentpage(1);
		}
		Integer currentPage = staffBean.getCurrentpage();
		Integer count = queryBizImp.addCount(staffBean);
		if (count == 0) {
			count =1 ;
		}
	  
		
		
		List<StaffBean> userList = queryBizImp.queryAll(staffBean);
		System.out.println("userList:"+userList.toString());
		model.addAttribute("userList", userList);
		return "BackEnd/report_show";
		
	}
	
}
