package org.great.controller;


import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.great.bean.AdminBean;
import org.great.bean.JurdisBean;
import org.great.biz.AdminBiz;
import org.great.biz.JurisdictionBiz;
import org.great.core.SystemLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@Resource
	private JurisdictionBiz jurisdictionBizImp;//权限接口
	
	ModelAndView mav = new ModelAndView();
	/*
	 * 后台登陆
	 */

	@RequestMapping(value="adminLogin.action",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView adminLogin(HttpServletRequest request,HttpServletResponse response,AdminBean aBean,Model model)throws UnsupportedEncodingException {

		System.out.println("后台登陆"+aBean.getAdminId()+aBean.getAdminPwd());
		adminBean = adminBizImp.adminLogin(aBean);
		 String flag = request.getParameter("isLogin");
		if(null != adminBean) {
			model.addAttribute("user",adminBean); 
			if(request.getParameter("check")!=null) {
				
		      addCookie(""+aBean.getAdminId(),aBean.getAdminPwd(), response, request);
		   }
			HttpSession session = request.getSession();
			session.setAttribute("adminBean", adminBean);
			System.out.println("登陆成功");

			//查询所有权限
			List<JurdisBean> allList = jurisdictionBizImp.selectAllJurd();
			//查询当前用户拥有的父权限
			List<JurdisBean> parentList = jurisdictionBizImp.selectAllParentJurd(adminBean.getRoleId());
			//查询单前用户拥有的子权限
			List<JurdisBean> sonList = jurisdictionBizImp.selectAllSonJurd(adminBean.getRoleId());
			
			model.addAttribute("allList", allList);
			model.addAttribute("parentList", parentList);
			model.addAttribute("sonList", sonList);
			
			mav.setViewName("BackEnd/admin_Index");
		}else {
			System.out.println("登陆失败");
			mav.setViewName("BackEnd/admin_login");
		}
		return mav;
	}
	
	/**
     * 添加Cookie
     * @param userName
     * @param password
     * @param response
     * @param request
     * @throws UnsupportedEncodingException
     */
    public static void addCookie(String userName,String password,HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException{
    	
        //创建cookie
        Cookie nameCookie = new Cookie(userName, password);
        nameCookie.setPath(request.getContextPath()+"/");//设置cookie路径
        //设置cookie保存的时间 单位：秒
        nameCookie.setMaxAge(7*24*60*60);
        //将cookie添加到响应
        response.addCookie(nameCookie);            
    }
	
    /**
     * 获取到Cookie
　　　* 先把所有的Cookie获取到，然后遍历cookie，如果有符合项就取出来，用map装起来发到页面中
     * @param userName
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getCookie.action",method=RequestMethod.POST)
    public Map<String, String> initCookie(String adminId, HttpServletRequest request){
    	
        Cookie[] cookie = request.getCookies();
        Map<String, String> map = new HashMap<>();
        
        for(Cookie c : cookie) {
        	
            if(c.getName().equals(adminId)) {
                String password = c.getValue();
              
                map.put("userName", adminId);
                map.put("password", password);
                return map;
            }
        }
        return null;
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

	
	/*
	 * 修改后台用户密码
	 */
	@RequestMapping(value="updateAdminPws.action")
	public  ModelAndView updateAdminPws(String adminPwd,int adminId) {
		
		adminBizImp.updateAdminPws(adminPwd,adminId);
		
		//跳转到用户展示的方法
		return mav;
		
	}
	
	/*
	 * 修改后台医生状态（禁用启用）
	 */
	@RequestMapping(value="updateDoctorState.action")
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
	

	
}  

