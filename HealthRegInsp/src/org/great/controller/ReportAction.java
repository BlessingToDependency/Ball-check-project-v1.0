/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.controller 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午9:54:59 
 */
package org.great.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.IntegerTypeHandler;
import org.great.bean.AdminBean;
import org.great.bean.BillBean;
import org.great.bean.LitemBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.SmallBean;
import org.great.bean.StaffBean;
import org.great.bean.TermBean;
import org.great.bean.TotalBean;
import org.great.biz.ISummaryBiz;
import org.great.biz.ReportBiz;
import org.great.biz.ReportBizImp;
import org.great.core.SystemLog;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/** 
 * @ClassName: ReportAction 
 * @Description: 总结报告
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午9:54:59  
 */
@Controller
@RequestMapping("/Report")
public class ReportAction {

	@Resource
	private TotalBean totalBean;  //总结类实体
	
	
	@Resource
	private ISummaryBiz SummaryBizImp;
	
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
	@Resource
	private ReportBiz reportBizImp;  //报告类接口
	private Integer currentPage;     //当前页数
	private Integer totalPage;		 //总页数
	
	   
	@RequestMapping("/showRepoert.action")	
	public String  showRepoert( Model model,TotalBean totalBean) {
		totalBean.setGuChId("1");
		totalBean =  reportBizImp.showReport(totalBean.getGuChId());
		System.out.println("totalBean:"+totalBean.toString());
		model.addAttribute("totalBean", totalBean);		
		return "BackEnd/user_report_summary";
	}

	//展示总结中的公司
	@RequestMapping("/showCompany.action")
	@SystemLog(module="总结",methods="日志管理，显示总结公司")
	public String showCompany(Model model,Integer currentPage,String company) {
		System.out.println("company:"+company);
		Integer count = reportBizImp.countPage(company);
		totalPage = count % 5 > 0 ? count / 5 + 1 : count / 5;
		if (totalPage==0) {
			totalPage=1;
		}
		if (null==currentPage) {
			currentPage =1 ;
		}
		List<BillBean> billList = reportBizImp.showCompany(company, currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);
	
		model.addAttribute("billList", billList);
		model.addAttribute("company", company);
		return "BackEnd/report_company";
		
	}
	//展示总结单
	@RequestMapping("/showUser.action")
	public  String  showUser(Model model, Integer companyId,PerguirelaBean pBean,String staffName,String  orderTime) {
	// System.out.println("pBean:"+pBean.toString());
		session.setAttribute("orderTime", orderTime);
		List<StaffBean> guideList = reportBizImp.findGuChId(companyId);
		System.out.println("guideList:"+guideList.toString());
		int  i =1;
		for (Iterator<StaffBean> iterator = guideList.iterator(); iterator.hasNext();) {
			StaffBean staffBean = (StaffBean) iterator.next();
			System.out.println("staffBean.getMyGuChId():"+staffBean.getMyGuChId());		
			if (null == staffBean.getMyGuChId()) {
				
			}else {				
				Integer sumSmall =reportBizImp.sumSmall(staffBean.getMyGuChId());
				Integer  sumOrder = reportBizImp.sumOrderItem(staffBean.getMyGuChId());
				System.out.println("sumSmall:"+sumSmall);
				System.out.println("sumOrder:"+sumOrder);
				System.out.println("sumSmall:"+sumSmall+"sumOrder:"+sumOrder);
				System.out.println("名字："+staffBean.getStaffName());
				if (staffBean.getSmallState()==13) {				
					if (sumSmall == sumOrder) {			
						System.out.println("111111111111重复次数："+i);
						reportBizImp.setSmall(staffBean.getMyGuChId());
						
					}
				}
			}
			
		}
		
		
	 Integer count = reportBizImp.countUser(companyId,pBean, staffName);
	 totalPage = count % 5 > 0 ? count / 5 + 1 : count / 5;
		if (totalPage==0) {
			totalPage=1;
		}
		if (null==pBean.getCurrentPage()) {
			pBean.setCurrentPage(1);
		}
		List<StaffBean> slist = reportBizImp.findUserById(companyId, pBean, staffName);
		Integer currentPage =pBean.getCurrentPage();
		//动态获取年份
		List<String> orderyear = reportBizImp.queryYear();		
		model.addAttribute("orderyear", orderyear);
		model.addAttribute("pBean", pBean);
		System.out.println("pBean:"+pBean.toString());
		model.addAttribute("slist", slist);
		model.addAttribute("companyId", companyId);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("count", count);
		model.addAttribute("staffName", staffName);
		System.out.println("slist:"+slist.toString());
		session.setAttribute("companyId", companyId);
		
		return "BackEnd/report_user";		
	}
	

	//ajax动态获取批次号
	@RequestMapping(value="showBatch.action")
	@ResponseBody
	public void  showBatch (PerguirelaBean pBean) throws IOException {
		//动态获取批次
		System.out.println("pBean:"+pBean);
		List<Integer> batch  = reportBizImp.queryBatch(pBean);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String str = gson.toJson(batch);
		out.print(str);	
		out.close();
	}
	

	
	//获取小结、展示小结
	@RequestMapping(value="showSmall.action")
	public ModelAndView showSmall(Model model,StaffBean staffBean,RedirectAttributes attr) {
		ModelAndView mav  = new ModelAndView();
		System.out.println("myGuChId:"+staffBean.getMyGuChId());
			List<SmallBean> smList = reportBizImp.queryItem(staffBean);		
			List<TermBean>   tList  = null;
			System.out.println("smList:"+smList.toString());
			Map<SmallBean, List<TermBean> > map = new HashMap<SmallBean, List<TermBean>>();
			for (Iterator<SmallBean> iterator = smList.iterator(); iterator.hasNext();) {
				SmallBean smallBean = (SmallBean) iterator.next();					
				tList =reportBizImp.querySection(smallBean);
				map.put(smallBean, tList);
			}	
			//根据导检单号以及项目ID找到对应图片
			int itemID = SummaryBizImp.getItemIds(staffBean.getMyGuChId());
			List<String> fileNameList= SummaryBizImp.imageFile(staffBean.getMyGuChId(), itemID);
			request.setAttribute("fileNameList", fileNameList);
			request.setAttribute("itemID", itemID);

			mav.addObject("itemMap", map);
			mav.addObject("staffBean", staffBean);
			
			System.out.println("itemMap:"+map.toString());
	
	
		mav.setViewName("BackEnd/report_summary");
		return mav;		
	}
	
	//插入总结
	@RequestMapping("insertTotall.action")
	@SystemLog(module="总结",methods="日志管理，插入总结")
	public ModelAndView insertTotall(TotalBean totalBean,RedirectAttributes attr) {
		System.out.println("totalBean:"+totalBean.toString());
		//session.setAttribute("adminBean", adminBean);
		AdminBean adminBean =   (AdminBean) session.getAttribute("adminBean");
		System.out.println("adminBean:"+adminBean.toString());
		totalBean.setDoctor(adminBean.getAdminName());  //登录得到
	//	totalBean.setGuChId("6");   //得到小结表
		totalBean.setDocSummary(15); //这个保留
		
		//改变用户人员的状态
		reportBizImp.changeState(totalBean);
		
		//实际体检人数
		String  orderTime =  (String) session.getAttribute("orderTime");
		reportBizImp.addUser(orderTime);
		
		System.out.println("totalBean:"+totalBean.toString());
		reportBizImp.insertTotal(totalBean);
		Integer  companyId =  (Integer) session.getAttribute("companyId");
		attr.addAttribute("companyId", companyId);
		//少了参数 用户ID？
		return new ModelAndView("redirect:/Report/showUser.action");		
	}
		
	
	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}


	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}


	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
