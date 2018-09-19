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
@RequestMapping("/adminLoginAction")
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

	
	/*
	 * 修改后台用户密码
	 */
	@RequestMapping(value="/updateAdminPws.action")
	public  ModelAndView updateAdminPws(String adminPwd,int adminId) {
		
		adminBizImp.updateAdminPws(adminPwd,adminId);
		
		//跳转到用户展示的方法
		return mav;
		
	}
	
	/*
	 * 修改后台医生状态（禁用启用）
	 */
	@RequestMapping(value="/updateDoctorState.action")
	public ModelAndView updateDoctorState(AdminBean aBean) {
		
		adminBizImp.updateDoctorState(aBean);
		
		//跳转到用户展示的方法
		return mav;
	}
	
	/*
	 * 逻辑删除医生
	 */
	@RequestMapping(value="/logicDeleteDoc.action")
	public ModelAndView logicDeleteDoc(AdminBean aBean) {
		
		adminBizImp.logicDeleteDoc(aBean);
		//跳 转到用户展示的方法
		return mav;

	}
	
	/*
	 * 后台对医生信息进行修改
	 */
	@RequestMapping(value="/updateDoctorInfo.action")
	public  ModelAndView updateDoctorInfo(AdminBean aBean) {
		
		adminBizImp.updateDoctorInfo(aBean);
		
		//跳 转到用户展示的方法
		return mav;		
	}
	
	/*
	 * 查询医生信息
	 */
	
}  

