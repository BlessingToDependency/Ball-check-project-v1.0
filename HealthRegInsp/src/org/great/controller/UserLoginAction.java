package org.great.controller;
/*
 * 前台用户登陆
 */

import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.great.bean.UserBean;
import org.great.biz.UserBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/userLoginAction")
public class UserLoginAction {
	@Resource 
	private UserBean userBean;//前台用户bean
	@Resource
	private UserBiz userBizImp;//前台用户接口

	ModelAndView mav = new ModelAndView();
	
	/*
	 * 用户登陆
	 */
	@RequestMapping("/userLogin.action")
	public ModelAndView userLogin(HttpServletRequest request,HttpServletResponse response,UserBean uBean) {
		userBean = userBizImp.userLogin(uBean);
		//登陆成功则进入if
		if(null != userBean) {
			HttpSession session = request.getSession();
			session.setAttribute("userBean", userBean);
			mav.setViewName("success");//登陆成功后跳转主页
		}else {
			mav.setViewName("login");//登陆失败
		}
		return mav;
	}
	
	/*
	 * 用户注册:存在问题
	 */
	@RequestMapping("/userRegister.action")
	public ModelAndView userRegister(UserBean uBean) {
		userBizImp.userRegister(uBean);
		mav.setViewName("login");
		return mav;
	}
	
	/*
	 * AJAX判断公司注册名是否重复:传入公司名
	 */
	@RequestMapping("/userRepeat.action")
	@ResponseBody
	public void userRepeat(HttpServletRequest request,HttpServletResponse response,String company)throws Exception{
		String str;
		UserBean ub = userBizImp.userRepeat(company);
		PrintWriter out = response.getWriter();
		
		//1=重复；2=不重复
		if(null != ub) {
			str ="1";
		}else {
			str ="2";
		}
		out.print(str);
		out.close();
	}
	
	/*
	 * 修改后台用户密码
	 */
	@RequestMapping(value="/updateUserPws.action")
	public  ModelAndView updateAdminPws(String pwd,String company) {
		
		
		userBizImp.updateUserPws(pwd,company);
		//跳转到用户展示的方法
		return mav;
		
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public UserBiz getUserBizImp() {
		return userBizImp;
	}

	public void setUserBizImp(UserBiz userBizImp) {
		this.userBizImp = userBizImp;
	}
	
}
