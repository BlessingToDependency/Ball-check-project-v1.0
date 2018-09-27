package org.great.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.AdminBean;
import org.great.bean.ParamBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.biz.IMissInspBiz;
import org.great.search.BatchSheetCon;
import org.great.search.CompanyCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
/*
 * 团检单位开单
 */
@Controller
@RequestMapping("/openBillAction")
public class MissInspAction {  
	@Autowired
	private HttpServletResponse response;
	
	@Resource
	private IMissInspBiz MissInspBizImp;
	//获取提交体检请求的单位列表
	@RequestMapping(value="/massInspList.action")
	public ModelAndView CompanyList(HttpServletRequest request,CompanyCon companyCon,Integer pageNo){
		
		int page=0;//当前页初始值
		String pno = pageNo+"";   //转换成String
		if("null".equals(pno) || "".equals(pno)){
			page=1;
			companyCon.setStatrRn(page*5);
			companyCon.setEndRn(page*5-4);
		}else{
			page = Integer.parseInt(pno);   //转换成Int类型
			companyCon.setStatrRn(page*5);
			companyCon.setEndRn(page*5-4);
		}	
		//得到展示的数据List
		List<UserBean> openBillList=MissInspBizImp.companyList(companyCon);
		//得到总数据
		List<UserBean> allOpenBillList=MissInspBizImp.allCompanyList(companyCon);
		//获得页码
		int allRecord=allOpenBillList.size();
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
		request.setAttribute("companyCon", companyCon);
		//展示的列表
		request.setAttribute("openBillList", openBillList);
		//当前页数
		request.setAttribute("pageNo", page);
		//总的页数
		request.setAttribute("AllPage", AllPage);
		//总的记录数
		request.setAttribute("allRecord", allRecord);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BackEnd/OpenBillList");
		return mav;
	}
	//跳转到单位人员信息展示界面
	@RequestMapping(value="/staff.action")
	public ModelAndView staffList(HttpServletRequest request,BatchSheetCon batchSheetCon,Integer pageNo){
		
		int page=0;//当前页初始值
		String pno = pageNo+"";   //转换成String
		if("null".equals(pno) || "".equals(pno)){
			page=1;
			batchSheetCon.setStatrRn(page*5);
			batchSheetCon.setEndRn(page*5-4);
		}else{
			page = Integer.parseInt(pno);   //转换成Int类型
			batchSheetCon.setStatrRn(page*5);
			batchSheetCon.setEndRn(page*5-4);
		}	
		//得到展示的数据List
		List<StaffBean> staffList = MissInspBizImp.staffList(batchSheetCon);
		//得到总数据
		List<StaffBean> allStaffList=MissInspBizImp.allStaffList(batchSheetCon);
		//得到年份
		List<String> years = MissInspBizImp.yearsList(batchSheetCon.getCompanyId());
		//获得页码
		int allRecord=allStaffList.size();
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
		//年份
		request.setAttribute("years", years);
		//搜索条件
		request.setAttribute("batchSheetCon", batchSheetCon);
		//展示的列表
		request.setAttribute("staffList", staffList);
		//当前页数
		request.setAttribute("pageNo", page);
		//总的页数
		request.setAttribute("AllPage", AllPage);
		//总的记录数
		request.setAttribute("allRecord", allRecord);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BackEnd/StaffList");
		return mav;
	}
	//获得批次号
	@RequestMapping(value="/getBatchNum.action")
	public ModelAndView GetBatchNum(HttpServletRequest request,String partYear,String companyId){
		try {
			PrintWriter out =response.getWriter();
			//通过gson进行传输
			Gson gson=new Gson();
			int comId = Integer.parseInt(companyId);
			List<String> batchNum= MissInspBizImp.batchNum(partYear, comId);
			String msg=gson.toJson(batchNum);
			out.print(msg);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//开单
	@RequestMapping(value="/openBill.action")
	public ModelAndView OpenBill(HttpServletRequest request,String partYear,int companyId,int batchNum,int staffId){
		//得到用户的导检单号
		String guChId = partYear+"-"+companyId+"-"+batchNum+"-"+staffId;
		System.out.println(guChId);
		
		
		//得到  员工导检单关系表  中的 人员导检ID
		//更新 员工表中的  最新导检单号字段内容
		//维护导检单ID 和 对应 套餐表
		
		
		//根据员工ID得到所选的套餐ID
		List<String> list =MissInspBizImp.setMealid(staffId);
		for(int i=0;i<list.size();i++) {
			int a = Integer.parseInt(list.get(i));
			int res = MissInspBizImp.maintain(guChId, a);
		}
		//跳转到导检单的页面（十一期间拓展一下）
		System.out.println("展示导检单内容，并能实现打印");
		return null;
	}
	//批量开单
	@RequestMapping(value="/batchOpenBill.action")
	public ModelAndView batchOpenBill(HttpServletRequest request,String partYear,int companyId,int batchNum,String[] data){
		for(int i=0;i<data.length;i++) {
			int staffId = Integer.parseInt(data[i]);
			//得到用户的导检单号
			String guChId = "CY-jx1803-"+partYear+"-"+companyId+"-"+batchNum+"-"+staffId;
			System.out.println(guChId);
			//根据员工ID得到所选的套餐ID
			List<String> list =MissInspBizImp.setMealid(staffId);
			for(int j=0;i<list.size();j++) {
				int a = Integer.parseInt(list.get(j));
				//维护导检单ID 和 对应 套餐表
				int res = MissInspBizImp.maintain(guChId, a);
			}
		}
		//跳转到导检单的页面
		System.out.println("展示导检单内容，并能实现打印");
		return null;
	}
}
