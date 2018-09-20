/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.controller 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午11:21:15 
 */
package org.great.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.SetmealBean;
import org.great.biz.OderBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @ClassName: OrderAction 
 * @Description: 订单展示
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午11:21:15  
 */
@Controller
@RequestMapping("order")
public class OrderAction {

	
	@Resource
	private  OderBiz oderBizImp;
	private Integer currentPage;
	private Integer totalPage;
	
	public String showOrder(HttpServletRequest request,Model model,SetmealBean setmealBean) {
		
		
		return null;
	}

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
