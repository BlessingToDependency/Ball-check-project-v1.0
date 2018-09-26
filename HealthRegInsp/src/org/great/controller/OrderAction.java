/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.controller 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午11:21:15 
 */
package org.great.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.great.bean.LitemBean;
import org.great.bean.SetmealBean;
import org.great.biz.OderBiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.sun.swing.internal.plaf.metal.resources.metal;

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
	@Autowired 
	private ServletConfig config;
	@Autowired
	private ServletContext servletContext;
	@Resource
	private   OderBiz oderBizImp;
//	private Integer currentPage;
	private Integer totalPage;
	
	//显示套餐
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

		String  setmeal  =  setmealBean.getSetmeal();
		List<SetmealBean> orderList = oderBizImp.showOder(setmeal, currentPage);		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("orderList", orderList);	
		model.addAttribute("count", count);
		model.addAttribute("setmeal", setmeal);
		return "BackEnd/order_list";
	}

	//显示套餐的项目 (加了setmeal了 等待测试）
	@RequestMapping("/showItem.action")  
	public String  showItem(Model model,Integer setmealId,String setmeal) throws IOException {	
		System.out.println("显示套餐ID："+setmealId);
	    List<LitemBean> itemList = oderBizImp.findItemById(setmealId);
	    List<LitemBean>  allList = oderBizImp.findItemById(null);
	    System.out.println("itemList:"+itemList.toString());
		model.addAttribute("itemList",itemList);	
		model.addAttribute("allList",allList);
		model.addAttribute("setmealId", setmealId);	
		model.addAttribute("setmeal", setmeal);
		return "BackEnd/order_additem";
		//return "BackEnd/order_list_edit";
	}
	
	
	//删除套餐
	@RequestMapping("/delteOrder.action")
	public ModelAndView  delteOrder(Model model,Integer setmealId) throws IOException {		
		 
		oderBizImp.deleteOrder(setmealId);
		//model.addAttribute("itemList",itemList);	
		
		return   new ModelAndView("redirect:/Order/showOrder.action");
	}
	
	//删除套餐中的项目
	@RequestMapping("/deleteItem.action")
	public ModelAndView deleteItem(Integer comId,RedirectAttributes attr,Integer setmealId) {
		oderBizImp.deleteItem(comId);			
		attr.addAttribute("setmealId", setmealId);
		return new ModelAndView("redirect:/Order/showItem.action");			
	}
	
	//新增套餐
	@RequestMapping(value="/addOrder.action",method=RequestMethod.POST)
	public ModelAndView addOrder(@RequestParam MultipartFile myPic, SetmealBean setmealBean) throws IllegalStateException, IOException {
		System.out.println("setmealBean:"+setmealBean.toString());
		String filename = myPic.getOriginalFilename();
		System.out.println("获取到的文件名："+filename);
		String root = request.getServletContext().getRealPath("/upload");
		System.out.println(root);
		myPic.transferTo(new File(root+"/"+filename));
		oderBizImp.addOrder(setmealBean, filename);
			
		return new ModelAndView("redirect:/Order/showItem.action");		
	}
	
	//增加套餐中的项目
	@RequestMapping("/addItem.action")
	public ModelAndView addItem(Integer[] itembox,Integer  setmealId ) {
		
		for (int i = 0; i < itembox.length; i++) {
			Integer itemId = itembox[i];
			System.out.println("itemId:"+itemId);
			oderBizImp.addItem(setmealId, itemId);
		}
/*		ModelAndView mav = new ModelAndView();
		List<LitemBean> itemList = oderBizImp.findItemById(null);		
		mav.addObject("itemList", itemList);
		mav.setViewName("BackEnd/order_additem");*/
		return  new ModelAndView("redirect:/Order/showOrder.action");		
	}
	
	//修改套餐名
	@RequestMapping("/updateItem.action")
	public  ModelAndView updateItem(Integer setmealId,String setmeal,RedirectAttributes attr) {
		System.out.println("setmealId"+setmealId+"setmeal:"+setmeal);
		oderBizImp.updateOrder(setmealId, setmeal);
		attr.addAttribute("setmeal", setmeal);
		
		return new ModelAndView("redirect:/Order/showItem.action");
		
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
