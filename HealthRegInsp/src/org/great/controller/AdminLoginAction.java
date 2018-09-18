package org.great.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.AdminBean;
import org.great.biz.AdminBiz;
import org.great.biz.AdminBizImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * 后台登陆
 */
import org.springframework.web.servlet.ModelAndView;
/*
 * 后台登陆
 */
@Controller
@RequestMapping("/userLoginAction")
public class AdminLoginAction {
	
	@Resource 
	private AdminBean adminBean;//后台bean
	
	@Resource
	private AdminBiz adminBizImp;//前台用户接口
	
	ModelAndView mav = new ModelAndView();
	
	@RequestMapping("/adminLogin.action")
	public ModelAndView adminLogin(HttpServletRequest request,HttpServletResponse response,AdminBean aBean) {

		adminBean = adminBizImp.adminLogin(aBean);
		if(null != adminBean) {
			HttpSession session = request.getSession();
			session.setAttribute("adminBean", adminBean);
			mav.setViewName("success");
		}else {
			mav.setViewName("error");
		}
		return mav;
	}
	/*
	 * 新增用户
	 */
	@RequestMapping("/adminRegister.action")
	public ModelAndView adminRegister(HttpServletRequest request,AdminBean aBean){
		
		adminBizImp.adminRegister(aBean);
		mav.setViewName("login");
		return mav;
	}
}
