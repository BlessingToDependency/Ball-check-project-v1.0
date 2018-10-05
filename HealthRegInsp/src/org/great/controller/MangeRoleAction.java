package org.great.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.AdminBean;
import org.great.bean.RoleBean;
import org.great.biz.IRoleBiz;
import org.great.core.SystemLog;
import org.great.mapper.IRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/*
 * 管理角色
 */
@Controller
@RequestMapping("/maRoleAction")
public class MangeRoleAction {

	@Resource
	private IRoleBiz roleBizImp;//前台接口
	@Resource 
	private RoleBean roleBean;//后台bean
	
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
	 * 查询角色
	 */
	@RequestMapping(value="selectAllRole.action")
/*	@SystemLog(module="角色管理",methods="日志")*/
	public ModelAndView selectAllRole() {
		String page=request.getParameter("page");
	
		 int pageNo=-1;
			if(null==page||"".equals(page)) {
				pageNo =1;
				
			}else {
				pageNo = Integer.parseInt(page);
				
			}
		
			
		int start = 5*pageNo-5; 
		int pagesize =5;
		RowBounds rowBounds = new RowBounds(start,pagesize);
		
		String role=request.getParameter("role");
		
		roleBean.setRole(role);
		mav.addObject("page", pageNo);
		List<RoleBean> roleList= roleBizImp.selectAllRole(roleBean,rowBounds);
		
		List<RoleBean>  roleNum=roleBizImp.selectRoleNum(roleBean);
		int paNum=0;
		int num=roleNum.size();
		
		if(num%5==0) {
			paNum=num/5;
		}
		if(num%5!=0) {
			paNum=num/5+1;
	}
		 mav.addObject("paNum", paNum);		
		session.setAttribute("roleList", roleList);
		mav.setViewName("BackEnd/mange_role");
		return mav;
		
	}
	
	/*
	 * 跳转到修改角色名窗口
	 */
	@RequestMapping(value="tomaRole.action")
	public  @ResponseBody void tomaRole() throws Exception{
		String roleI=request.getParameter("roleId");
		session.setAttribute("roleI", roleI);
		
		PrintWriter out = response.getWriter();
		String msg="OK";
		Gson gson1 = new Gson();
		String str1 = gson1.toJson(msg);
		out.print(str1);
		out.close();
		
		
	}
	
	/*
	 * 修改角色名窗口
	 */
	@RequestMapping(value="updateRoleNmae.action")
	public  ModelAndView updateRoleNmae(RoleBean roleBean) {
		
		String rol=(String) session.getAttribute("roleI");
		int roleId=Integer.parseInt(rol);		
		roleBean.setRoleId(roleId);	String mag=(String) session.getAttribute("msg");
		if(mag.equals("可用角色")) {		
		roleBizImp.updateRoleNmae(roleBean);	
		mav.setViewName("redirect:/maRoleAction/selectAllRole.action");
		}else {
			mav.setViewName("BackEnd/result");
		}
		return mav;
		
	}
	
	/*
	 * 返回角色界面
	 */
	@RequestMapping(value="toRoleM.action")
	public ModelAndView toRoleM() {
		return new ModelAndView("redirect:/maRoleAction/selectAllRole.action");
		
	}
	
	/*
	 * 跳转到新增据说界面
	 */
	@RequestMapping(value="toAddRole.action")
	 public ModelAndView  toAddRole() {
		mav.setViewName("BackEnd/add_role");
		return mav;
	}
	
	/*
	 * 新增角色
	 */
	@RequestMapping(value="innerRole.action")
	 public ModelAndView  innerRole(RoleBean roleBean) {
		
		String mag=(String) session.getAttribute("msg");
		if(mag.equals("可用角色")) {
			
			roleBizImp.innerRole(roleBean);
		mav.setViewName("redirect:/maRoleAction/selectAllRole.action");
		}
		else {
			mav.setViewName("BackEnd/result");
		}
		
		return mav;
	}
	
	/*
	 * 删除角色
	 */
	@RequestMapping(value="deleteRole.action")
	 public ModelAndView  deleteRole() {
		String rol=request.getParameter("roleId");
		System.out.println("ih="+rol);
		int roleId=Integer.parseInt(rol);
		roleBizImp.deleteRole(roleId);
		return new ModelAndView("redirect:/maRoleAction/selectAllRole.action");
		
	}
	
	/*
	 * 查重
	 */
	@RequestMapping(value="checkRole.action")
	 public @ResponseBody void  checkRole(RoleBean roleBean) throws Exception{
		String role=request.getParameter("role");
		roleBean.setRole(role);
		
		List<RoleBean>  roleList=roleBizImp.checkRole(roleBean);
		
		PrintWriter out = response.getWriter();
		String msg;
		if(roleList.size()>0) {
			msg="角色已存在";
			
		}else {
			msg="可用角色";
		}
		session.setAttribute("msg", msg);
		Gson gson1 = new Gson();
		String str1 = gson1.toJson(msg);
		out.print(str1);
		out.close();
	}
	
	/*
	 * 查角色
	 */
	@RequestMapping(value="selectR.action")
	public  @ResponseBody void selectR() throws Exception{
		String adminId=request.getParameter("adminId");
		
		session.setAttribute("uadminId", adminId);
		List<RoleBean> roList=roleBizImp.selectR();
		request.setAttribute("roList", roList);
		PrintWriter out = response.getWriter();
		Gson gson1 = new Gson();
		String str1 = gson1.toJson(roList);
		out.print(str1);
		out.close();	
	}
}
