package org.great.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.SetmealBean;
import org.great.biz.AdminBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*
 * 科室医生体检处理
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
@Controller
@RequestMapping("doctorAction")
public class DoctorAction {
	
	private List<SetmealBean> setmealList;
	@Resource
	private SetmealBean setmealBean;//套餐表
	ModelAndView mav = new ModelAndView();
	@Resource
	private AdminBiz adminBizImp;//后台接口
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	//跳转科室医生查询界面
	@RequestMapping("/doctorMain.action")
	public ModelAndView doctorMain() {
		mav.setViewName("BackEnd/doctormain");
		return mav;
	}
	
	//通过导检单id查询套餐
	@RequestMapping("/selectSetmeal.action")
	public void selectSetmeal(String guChId) throws Exception{
		
		System.out.println("guChId="+guChId);
		System.out.println(adminBizImp.selectSetmeal(guChId).size());
		setmealList = adminBizImp.selectSetmeal(guChId);
		
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String str = gson.toJson(setmealList);
		out.print(str);
		out.close();
	} 
}
