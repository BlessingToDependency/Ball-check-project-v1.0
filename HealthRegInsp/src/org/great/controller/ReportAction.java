/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.controller 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午9:54:59 
 */
package org.great.controller;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.TotalBean;
import org.great.biz.ReportBiz;
import org.great.biz.ReportBizImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/** 
 * @ClassName: ReportAction 
 * @Description: 总结报告
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午9:54:59  
 */
@Controller
@RequestMapping("/Report")
public class ReportAction {

	@Resource
	private TotalBean totalBean;  //总结类实体
	
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
	private ReportBiz reportBizImp;  //报告类接口
	private Integer currentPage;     //当前页数
	private Integer totalPage;		 //总页数
	
	   
	@RequestMapping("/showRepoert.action")	
	public String  showRepoert( Model model,TotalBean totalBean) {
		totalBean.setGuChId("1");
		totalBean =  reportBizImp.showReport(totalBean.getGuChId());
		System.out.println("totalBean:"+totalBean.toString());
		model.addAttribute("totalBean", totalBean);		
		return "BackEnd/user_report_summary";
	}

/*	@RequestMapping("/showRepoert.action")	
	public ModelAndView  showRepoert( TotalBean totalBean) {
		totalBean.setGuChId("1");
		totalBean =  reportBizImp.showReport(totalBean.getGuChId());
		System.out.println("totalBean:"+totalBean.toString());
		ModelAndView mav  =new ModelAndView();
		mav.addObject("totalBean", totalBean);
		mav.setViewName("BackEnd/user_report_summary");
		return mav;
	}*/
	
	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}


	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}


	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
