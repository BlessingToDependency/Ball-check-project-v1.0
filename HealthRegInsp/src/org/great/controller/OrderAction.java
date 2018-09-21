/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.controller 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午11:21:15 
 */
package org.great.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.SetmealBean;
import org.great.biz.OderBiz;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/Order")
public class OrderAction {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private  HttpSession session;
	
	@Resource
	private  OderBiz oderBizImp;
//	private Integer currentPage; 是的
	private Integer totalPage;
	@RequestMapping("/showOrder.action")
	public String showOrder(HttpServletRequest request,Model model,SetmealBean setmealBean,Integer currentPage) {
		
		if (null == currentPage) {
			currentPage = 1;
		}
		System.out.println("currentPage:"+currentPage);
		int count = oderBizImp.countOrder(setmealBean.getSetmeal());
		totalPage = count % 5 > 0 ? count / 5 + 1 : count / 5;
		if (totalPage==0) {
			totalPage=1;
		}
		List<SetmealBean> orderList = oderBizImp.showOder(setmealBean.getSetmeal(), currentPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("orderList", orderList);	
		model.addAttribute("count", count);
		return "BackEnd/order_list";
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
