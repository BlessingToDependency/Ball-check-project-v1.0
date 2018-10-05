package org.great.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import org.great.bean.AdminBean;
import org.great.bean.ParamBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.biz.IMissInspBiz;
import org.great.search.BatchSheetCon;
import org.great.search.CompanyCon;
import org.great.search.MedicalCheckup;
import org.great.tools.PhoneCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aliyuncs.exceptions.ClientException;
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
		//获得公司ID
		request.getSession().setAttribute("cId", batchSheetCon.getCompanyId());
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
		//从session中得到公司id
		int cid=(int) request.getSession().getAttribute("cId");
		//得到用户的导检单号
		String guChId = "CY-jx1803-"+partYear+"-"+companyId+"-"+batchNum+"-"+staffId;
		//更新 员工表中的  最新导检单号字段内容
		int re = MissInspBizImp.updateNewGuChid(staffId, guChId);
		//得到  员工导检单关系表  中的 人员导检对象
		PerguirelaBean pgb = MissInspBizImp.getPerInspId(partYear, companyId, batchNum, staffId);
		//获取套餐ID
		System.out.println(pgb.getPerInspId());
		List<Integer> setMealList = MissInspBizImp.setMeaList(pgb.getPerInspId());
		//套餐下的所有项目ID的列表
		List<Integer> itemList = new ArrayList<Integer>();
		//创建一个生成导检单对象
		MedicalCheckup mck = new MedicalCheckup();
		mck.setBatch(batchNum);//得到批次号
		mck.setGuChId(guChId);//得到导检单号
		mck.setCompanyId(companyId);//得到公司ID
		mck.setStaffId(staffId);//得到体检人员ID
		   
		for(int i=0;i<setMealList.size();i++) {
			//得到套餐ID
			int setmealId = setMealList.get(i);
			//维护  <导检单对应套餐表>
			int in = MissInspBizImp.intoGucHSet(setmealId, pgb.getPerInspId(), guChId);
		    //得到该套餐下的所有项目ID
			itemList = MissInspBizImp.itemList(setmealId);
			for(int j =0;j<itemList.size();j++) {
				//得到项目ID
				int itemId = itemList.get(j);
				//维护  <导检单对应项目表>
				int ir = MissInspBizImp.intoGuChItem(itemId, guChId);
			}
		}
		//在本地硬盘上生成导检单
		int s = MissInspBizImp.addConInspSheet(itemList,mck);
		if(s==1) {
			//把员工中的状态改为已经打印
			int res = MissInspBizImp.updatePrint(staffId);
			//根据员工id得到体检人员的信息
			StaffBean staff = MissInspBizImp.getStaffInfo(staffId);
			//得到用户的手机号进行短信提醒用户已经预约了时间
			String phone = staff.getPhone()+"";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
			String time = df.format(new Date());
			String tis =time+"号起的5个工作日内的公司体检";
			try {
				PhoneCode.Code(phone, staff.getStaffName(),tis);
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:/openBillAction/staff.action?companyId="+cid);
	}
	//批量开单
	@RequestMapping(value="/batchOpenBill.action")
	public ModelAndView batchOpenBill(HttpServletRequest request,String partYear,int companyId,int batchNum,String[] data){
		//从session中得到公司id
		int cid=(int) request.getSession().getAttribute("cId");
		for(int i=0;i<data.length;i++) {
			int staffId = Integer.parseInt(data[i]);
			//得到用户的导检单号
			String guChId = "CY-jx1803-"+partYear+"-"+companyId+"-"+batchNum+"-"+staffId;
			//更新 员工表中的  最新导检单号字段内容
			int re = MissInspBizImp.updateNewGuChid(staffId, guChId);
			//得到  员工导检单关系表  中的 人员导检对象
			PerguirelaBean pgb = MissInspBizImp.getPerInspId(partYear, companyId, batchNum, staffId);
			//获取套餐ID
			List<Integer> setMealList = MissInspBizImp.setMeaList(pgb.getPerInspId());
			//套餐下的所有项目ID的列表
			List<Integer> itemList = new ArrayList<Integer>();
			//创建一个生成导检单对象
			MedicalCheckup mck = new MedicalCheckup();
			mck.setBatch(batchNum);//得到批次号
			mck.setGuChId(guChId);//得到导检单号
			mck.setCompanyId(companyId);//得到公司ID
			mck.setStaffId(staffId);//得到体检人员ID
			
			for(int k=0;k<setMealList.size();k++) {
				//得到套餐ID
				int setmealId = setMealList.get(k);
				//维护  <导检单对应套餐表>
				int in = MissInspBizImp.intoGucHSet(setmealId, pgb.getPerInspId(), guChId);
			    //得到该套餐下的所有项目ID
				itemList = MissInspBizImp.itemList(setmealId);
				for(int j =0;j<itemList.size();j++) {
					//得到项目ID
					int itemId = itemList.get(j);
					//维护  <导检单对应项目表>
					int ir = MissInspBizImp.intoGuChItem(itemId, guChId);
				}
			}
			//在本地硬盘上生成导检单
			int s = MissInspBizImp.addConInspSheet(itemList,mck);
			if(s==1) {
				//把员工中的状态改为已经打印
				int res = MissInspBizImp.updatePrint(staffId);
				//根据员工id得到体检人员的信息
				StaffBean staff = MissInspBizImp.getStaffInfo(staffId);
				//得到用户的手机号进行短信提醒用户已经预约了时间
				String phone = staff.getPhone()+"";
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
				String time = df.format(new Date());
				String tis =time+"号起的5个工作日内的公司体检";
				try {
					PhoneCode.Code(phone, staff.getStaffName(),tis);
				} catch (ClientException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return new ModelAndView("redirect:/openBillAction/staff.action?companyId="+cid);
	}
}
