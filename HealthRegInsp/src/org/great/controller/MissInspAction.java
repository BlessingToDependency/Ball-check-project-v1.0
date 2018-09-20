package org.great.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.UserBean;
import org.great.biz.IMissInspBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 * 团检单位开单
 */
@Controller
@RequestMapping("/adminOpenBillAction")
public class MissInspAction {    
	
	@Resource
	private IMissInspBiz MissInspBizImp;
	//获取提交体检请求的单位列表
	@RequestMapping(value="/openBill.action")
	public ModelAndView BackLogin(HttpServletRequest request){
		//调用业务层
		List<UserBean> openBillList=MissInspBizImp.CompanyList();
		request.setAttribute("openBillList", openBillList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BackEnd/OpenBillList");
		return mav;
	}
	//下载团检单位提供的体检人员名单
	@RequestMapping(value="/downUnitList.action")
	public ModelAndView DownUnitList(HttpServletRequest request,String name){
		System.out.println("********"+name);
		//调用业务层
		List<UserBean> openBillList=MissInspBizImp.CompanyList();
		request.setAttribute("openBillList", openBillList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BackEnd/OpenBillList");
		return mav;
	}

}
