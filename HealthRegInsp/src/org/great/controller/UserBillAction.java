package org.great.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.AdminBean;
import org.great.bean.BillBean;
import org.great.bean.UserBean;
import org.great.biz.UserBiz;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 前台记账
 */
@Component
@RequestMapping("/userBillAction")
public class UserBillAction {

	@Resource
	private BillBean billBean;//账单Bean
	
	@Resource
	private UserBiz userBizImpl;//前台用户接口
	
	ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="userBill.action")
	public ModelAndView userBill(HttpServletRequest request,BillBean billBean) {
		
		//获取当前账号的信息
		UserBean ub =  (UserBean) request.getSession().getAttribute("userBean");
		
		//把公司id塞进账单bean
		billBean.setCompanyId(ub.getCompanyId());
		
		//账单信息增加进数据库
		userBizImpl.userBill(billBean);
		
		mav.setViewName("success");//增加成功调到主页面
		
		return mav;
		
	}
	
	@RequestMapping("/billInfo.action")
	public ModelAndView billInfo() {
		
		
		mav.setViewName("FrontEnd/user_Bill");
		return mav;
	}
}
