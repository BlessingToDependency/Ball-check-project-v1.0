package org.great.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.AdminBean;
import org.great.bean.ParamBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.biz.IAdminMangerBiz;
import org.great.biz.IMissInspBiz;
import org.great.biz.IParamConfigBiz;
import org.great.biz.ISummaryBiz;
import org.great.search.AdminCon;
import org.great.search.SumCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
/*
 * 医生小结
 */
@Controller
@RequestMapping("/doctorSummaryAction")
public class SummaryAction {   
	@Autowired
	private HttpServletResponse response;
	
	@Resource
	private ISummaryBiz SummaryBizImp;
	//获取对应科室已经体检完的用户信息
	@RequestMapping(value="/getThisItemStaff.action")
	public ModelAndView getStaffList(HttpServletRequest request,SumCon sunCon,Integer pageNo){
		int page=0;//当前页初始值
		String pno = pageNo+"";   //转换成String
		if("null".equals(pno) || "".equals(pno)){
			page=1;
			sunCon.setStatrRn(page*5);
			sunCon.setEndRn(page*5-4);
		}else{
			page = Integer.parseInt(pno);   //转换成Int类型
			sunCon.setStatrRn(page*5);
			sunCon.setEndRn(page*5-4);
		}	
		//获取对应项目的体检项目
		List<StaffBean> thisItemlist=SummaryBizImp.getSummaryList(request,sunCon);
		List<StaffBean> allthisItemlist = SummaryBizImp.getAllSummaryList(request, sunCon);
		//获得页码
		int allRecord=allthisItemlist.size();
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
		request.setAttribute("sunCon", sunCon);
		//展示的列表
		request.setAttribute("thisItemlist", thisItemlist);
		//当前页数
		request.setAttribute("pageNo", page);
		//总的页数
		request.setAttribute("AllPage", AllPage);
		//总的记录数
		request.setAttribute("allRecord", allRecord);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BackEnd/ThisItemStaffList");
		return mav;
	}
	
	//进行小结
	@RequestMapping(value="/makeSummary.action")
	public ModelAndView Summary(HttpServletRequest request){

		 
		return null;
	}
}
