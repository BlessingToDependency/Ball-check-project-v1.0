package org.great.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.AdminBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.biz.AdminBiz;
import org.great.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 * 用户管理
 */

import com.google.gson.Gson;

@Controller
@RequestMapping("/userAdminAction")
public class UserAdminAction {

	ModelAndView mav = new ModelAndView();
	@Resource
	private AdminBiz adminBizImp;//后台接口
	private UserBiz userBizImp;//前台接口
	private List<StaffBean> userList;
	private List<StaffBean> staffList;
	private List<UserBean> uList;
	private int pageCountAll=1;//总页数
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	//禁用公司
	@RequestMapping("/disableCompany.action")
	public ModelAndView disableCompany(String companyId,String stateId) {
		if(stateId.equals("3")) {
			stateId = "4";
		}else {
			stateId = "3";
		}
		adminBizImp.disableCompany(companyId,stateId);
		return new ModelAndView("redirect:/userAdminAction/company.action");
	}
	
	//删除公司
	@RequestMapping("/deleteCompany.action")
	public ModelAndView deleteCompany(String companyId,String logicId) {
		adminBizImp.deleteCompany(companyId,logicId);
		return new ModelAndView("redirect:/userAdminAction/company.action");
	}
	
	
	//展示公司列表
	@RequestMapping("/company.action")
	public ModelAndView company(UserBean userBean,Integer pages)throws Exception{
		String count = request.getParameter("pages");
		String page = String.valueOf(pages);
		if(page==null ||"null".equals(page)|| "".equals(page)||"0".equals(page)) {
			pages=1;
		}
		int countAll =adminBizImp.companyCount(userBean);//总数
		if(countAll%10>0||countAll==0) {
			pageCountAll=countAll/10+1;
		}else {
			pageCountAll=countAll/10;
		}
		
		uList = adminBizImp.company(userBean, pages);
		System.out.println("list="+uList.size());
		mav.setViewName("BackEnd/companylist");
		request.setAttribute("uList", uList);
		mav.addObject("userBean", userBean);//当前页
		mav.addObject("pageCountAll", pageCountAll);//总页
		mav.addObject("pages", pages);//当前页
		return mav;
	}
	
	
	//根据用户id查找对应信息
	@RequestMapping("userInfo.action")
	public void userInfo(String staffId)throws Exception {
		StaffBean staff = adminBizImp.userInfo(staffId);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String strCon = gson.toJson(staff);
		out.print(strCon);
		out.close();
	}
	
	//用户管理列表展示
	@RequestMapping("userAdmin.action")
	public ModelAndView userAdmin(StaffBean staffBean,Integer pages) {
		String page = String.valueOf(pages);
		if(page==null ||"null".equals(page)|| "".equals(page)||"0".equals(page)) {
			pages=1;
		}
		//分页
		int countAll=adminBizImp.userAdminCount(staffBean);//当前用户总个数
		if(countAll%10>0||countAll==0) {
			pageCountAll=countAll/10+1;
		}else {
			pageCountAll=countAll/10;
		}
		userList = adminBizImp.userAdmin(staffBean,pages);
		
		System.out.println(staffBean.toString());
		
		mav.setViewName("BackEnd/userlist");
		request.setAttribute("userList", userList);
		mav.addObject("staffBean", staffBean);
		mav.addObject("pageCountAll", pageCountAll);//总页
		mav.addObject("pages", pages);//当前页
		return mav;
	}
}
