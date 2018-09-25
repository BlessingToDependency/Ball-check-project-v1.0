package org.great.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.AdminBean;
import org.great.bean.ParamBean;
import org.great.bean.UserBean;
import org.great.biz.IAdminMangerBiz;
import org.great.biz.IMissInspBiz;
import org.great.biz.IParamConfigBiz;
import org.great.search.AdminCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
/*
 * 后台管理员管理
 */
@Controller
@RequestMapping("/adminManagerAction")
public class AdminManagerAction {   
	@Autowired
	private HttpServletResponse response;
	
	@Resource
	private IAdminMangerBiz AdminMangerImpBiz;
	//获取管理员列表
	@RequestMapping(value="/getAdminList.action")
	public ModelAndView GetAdmins(HttpServletRequest request,AdminCon adminCon,Integer pageNo){
		int page=0;//当前页初始值
		String pno = pageNo+"";   //转换成String
		if("null".equals(pno) || "".equals(pno)){
			page=1;
			adminCon.setStatrRn(page*5);
			adminCon.setEndRn(page*5-4);
		}else{
			page = Integer.parseInt(pno);   //转换成Int类型
			adminCon.setStatrRn(page*5);
			adminCon.setEndRn(page*5-4);
		}
		//得到展示的数据List
		List<AdminBean> adminList=AdminMangerImpBiz.getAdminList(adminCon);
		//得到总数据
		List<AdminBean> allAdminList=AdminMangerImpBiz.getAllAdminList(adminCon);
		//得到动态用户状态下拉框中的值
		List<ParamBean> userState=AdminMangerImpBiz.userState();
		//获得页码
		int allRecord=allAdminList.size();
		int AllPage=0;
		if(allRecord!=0) {
			if(allRecord%5!=0) {
				AllPage=(allRecord/5)+1;
			}else {
				AllPage=(allRecord/5);
			}
		}else {
			AllPage=1;
		}
		//搜索条件
		request.setAttribute("adminCon", adminCon);
		//展示的列表
		request.setAttribute("adminList", adminList);
		//用户状态动态列表
		request.setAttribute("userState", userState);
		//当前页数
		request.setAttribute("pageNo", page);
		//总的页数
		request.setAttribute("AllPage", AllPage);
		//总的记录数
		request.setAttribute("allRecord", allRecord);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BackEnd/AdminMangerList");
		return mav;
	}
	
	//启用
	@RequestMapping(value="/enableAdmin.action")
	public ModelAndView Enable(HttpServletRequest request,int adid){
		int res = AdminMangerImpBiz.endisAdmin(adid, 3);
		if(res>0) {
			return new ModelAndView("redirect:/adminManagerAction/getAdminList.action");
		}
		return null;
	}
	
	//禁用
	@RequestMapping(value="/disableAdmin.action")
	public ModelAndView Disable(HttpServletRequest request,int adid){
		int res = AdminMangerImpBiz.endisAdmin(adid, 4);
		if(res>0) {
			return new ModelAndView("redirect:/adminManagerAction/getAdminList.action");
		}
		return null;
	}
	
	//重置密码
	@RequestMapping(value="/resetPwd.action")
	public ModelAndView ResetPwd(HttpServletRequest request,int adid){
		int res = AdminMangerImpBiz.resetPwd(adid, "123456");
		if(res>0) {
			return new ModelAndView("redirect:/adminManagerAction/getAdminList.action");
		}
		return null;
	}
	
	//删除管理员
	@RequestMapping(value="/deletAdmin.action")
	public ModelAndView Delete(HttpServletRequest request,int adid){
		int res = AdminMangerImpBiz.delAdmin(adid);
		if(res>0) {
			return new ModelAndView("redirect:/adminManagerAction/getAdminList.action");
		}
		return null;
	}
	//检验身份证号是否重复
	@RequestMapping(value="/check.action")
	public ModelAndView CheckIdNum(HttpServletRequest request,String idNum){
		try {
			PrintWriter out =response.getWriter();
			//通过gson进行传输
			Gson gson=new Gson();
			int res = AdminMangerImpBiz.checkIdNum(idNum);
			String msg =null;
			if(res>0) {
				msg=gson.toJson("已存在");
			}
			out.print(msg);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//添加管理员
	@RequestMapping(value="/addAdmin.action")
	public ModelAndView AddAdmin(HttpServletRequest request,AdminBean admin,String[] chbname){
		if(chbname!=null) {
			int res = AdminMangerImpBiz.addAdmin(admin);
			if(res>0) {
				//得到注册的管理员ID
				int id = AdminMangerImpBiz.checkIdNum(admin.getIdNum());
				for(int i=0;i<chbname.length;i++) {
					int relaId = Integer.parseInt(chbname[i]);
					//维护关系表
					int r = AdminMangerImpBiz.addRela(relaId, id);
				}
			}
		}
		return new ModelAndView("BackEnd/AddAdmins");
	}
	
}
