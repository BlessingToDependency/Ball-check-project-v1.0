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
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.IntegerTypeHandler;
import org.great.bean.BillBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.SmallBean;
import org.great.bean.StaffBean;
import org.great.bean.TotalBean;
import org.great.biz.ReportBiz;
import org.great.biz.ReportBizImp;
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

	
	@RequestMapping("/showCompany.action")
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
	/*//展示总结单
	@RequestMapping("/showUser.action")
	public  String  showUser(Model model, Integer companyId,PerguirelaBean pBean,String staffName) {
	// System.out.println("pBean:"+pBean.toString());
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
		System.out.println("staffName:"+staffName);
		session.setAttribute("companyId", companyId);
		
		return "BackEnd/report_user";		
	}*/
	

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
	public String showSmall(Model model,Integer staffId) {
		
		List<SmallBean> sumList = reportBizImp.querySmall(staffId);
		model.addAttribute("sumList", sumList);
		
		return "BackEnd/report_summary";		
	}
	
	//插入总结
	@RequestMapping("insertTotall.action")
	public ModelAndView insertTotall(TotalBean totalBean,RedirectAttributes attr) {
		System.out.println("totalBean:"+totalBean.toString());

		totalBean.setDoctor("王俊贤");  //登录得到
		totalBean.setGuChId("6");   //得到小结表
		totalBean.setDocSummary(15); //这个保留
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
