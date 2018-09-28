package org.great.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.UserBean;
import org.great.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
/*
 * 用户对公司信息的处理
 */
@Controller
@RequestMapping("/myCompAction")
public class MyCompAction {
	@Resource 
	private UserBean userBean;//前台用户bean
	@Resource
	private UserBiz userBizImp;//前台用户接口

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
	 * 修改公司登陆密码
	 */

	@RequestMapping(value="/updateUserPws.action")
	public  ModelAndView updateAdminPws(String pwd) {		
		String msg=(String) session.getAttribute("msg");
		UserBean uBean=(UserBean) session.getAttribute("userBean");
		String company=uBean.getCompany();
		
		if(msg.equals("密码正确")) {
		userBizImp.updateUserPws(pwd,company);
		mav.setViewName("FrontEnd/user_index");
		}
		else {
		 mav.setViewName("FrontEnd/update_CompPws");
		}
		return mav;
		
	}
  
	/*
	 * 查询公司信息
	 */
	@RequestMapping(value="/selectCompInfo.action")
	public ModelAndView  selectCompInfo() {
		
		UserBean userBean=(UserBean) session.getAttribute("userBean");
		//String componey=userBean.getCompany();
		String componey="公司";
		List<UserBean> compList=userBizImp.selectCompInfo(componey);
		session.setAttribute("compList", compList);
		mav.setViewName("FrontEnd/company_Info");
		return mav;
	}
	
	
	/*
	 * 跳转到修改密码界面
	 */
	@RequestMapping(value="/toUpPws.action")
	public ModelAndView toUpPws() {
		
		mav.setViewName("FrontEnd/update_CompPws");
		return mav;
		
	}
	
	/*
	 * AJAX判断修改密码时，原密码是否正确
	 */
	@RequestMapping(value="/validateCompPws.action")
	public @ResponseBody void validateCompPws(UserBean uBean)throws Exception{
		PrintWriter out = response.getWriter();
		UserBean uBea=(UserBean) session.getAttribute("userBean");
		//String company=uBea.getCompany();
		String company="公司";
		uBean.setCompany(company);
		userBean = userBizImp.userLogin(uBean);
	String msg;
	if(userBean!=null) {
		msg="密码正确";
		
	}else {
		msg="密码错误";
	}
	session.setAttribute("msg", msg);
	Gson gson1 = new Gson();
	String str1 = gson1.toJson(msg);
	out.print(str1);
	out.close();
	
}
	
	/*
	 *跳转到编辑公司信息界面
	 */
	@RequestMapping(value="/toEditCompInfo.action")
	public ModelAndView toEditCompInfo() {
		UserBean userBean=(UserBean) session.getAttribute("userBean");
		//String componey=userBean.getCompany();
		String componey="公司";
		List<UserBean> compList=userBizImp.selectCompInfo(componey);
		session.setAttribute("compList", compList);
		mav.setViewName("FrontEnd/edit_ComInfo");
		return mav;
	}
	
	/*
	 *编辑公司信息
	 */
	@RequestMapping(value="/EditCompInfo.action")
	 public ModelAndView EditCompInfo(UserBean uBean) {
		
		
		uBean.setCompany("公司");
		userBizImp.updateCompInfo(uBean);
		mav.setViewName("FrontEnd/user_index");
		return mav;
	}
	
	
	/*
	 *返回到主界面
	 */
	@RequestMapping(value="/backIndex.action")
	public ModelAndView backIndex() {
		mav.setViewName("FrontEnd/user_index");
		
		return mav;
		
	}
	
}