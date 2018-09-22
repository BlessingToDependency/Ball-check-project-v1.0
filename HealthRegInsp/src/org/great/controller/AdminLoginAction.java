package org.great.controller;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.AdminBean;
import org.great.biz.AdminBiz;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/adminLoginAction")
public class AdminLoginAction {
	
	@Resource 
	private AdminBean adminBean;//后台bean
	
	@Resource
	private AdminBiz adminBizImp;//前台用户接口
	
	
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
	
	ModelAndView mav = new ModelAndView();
	/*
	 * 后台登陆
	 */
	@RequestMapping("adminLogin.action")
	public ModelAndView adminLogin(HttpServletRequest request,HttpServletResponse response,AdminBean aBean) {
		System.out.println("后台登陆"+aBean.getAdminId()+aBean.getAdminPwd());
		adminBean = adminBizImp.adminLogin(aBean);
		if(null != adminBean) {
			HttpSession session = request.getSession();
			session.setAttribute("adminBean", adminBean);
			System.out.println("登陆成功");
			mav.setViewName("BackEnd/admin_Index");
		}else {
			System.out.println("登陆失败");
			mav.setViewName("BackEnd/admin_Index");
		}
		return mav;
	}
	/*
	 * 新增用户
	 */
	@RequestMapping("adminRegister.action")
	public ModelAndView adminRegister(HttpServletRequest request,AdminBean aBean){
		
		adminBizImp.adminRegister(aBean);
		mav.setViewName("login");
		return mav;
	}

	
	
	
	
	
}  

