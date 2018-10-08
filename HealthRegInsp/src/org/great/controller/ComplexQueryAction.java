/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.controller 
 * @author: wjx(wangj)   
 * @date: 2018年10月7日 下午5:19:00 
 */
package org.great.controller;

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

import org.great.bean.SmallBean;
import org.great.bean.StaffBean;
import org.great.bean.TermBean;
import org.great.bean.TotalBean;
import org.great.biz.ISummaryBiz;
import org.great.biz.QueryBiz;
import org.great.biz.QueryBizImp;
import org.great.biz.ReportBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/** 
 * @ClassName: ComplexQueryAction 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月7日 下午5:19:00  
 */
@Controller
@RequestMapping("/ComQuery")
public class ComplexQueryAction {

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
	private QueryBiz queryBizImp;
	@Resource
	private ReportBiz reportBizImp;  //报告类接口
	@Resource
	private ISummaryBiz SummaryBizImp;
	/**
	 * 
	 * @Title: queryAll 
	 * @Description: 展示综合查询 
	 * @param model
	 * @param staffBean
	 * @return String
	 * @author: wjx(wangj)  
	 * @date 2018年10月8日上午12:42:45
	 */
	@RequestMapping("/queryAll.action")
	public  String queryAll(Model model,StaffBean staffBean) {
		if (null == staffBean.getCurrentpage()) {
			staffBean.setCurrentpage(1);
		}
	//	Integer currentpage = staffBean.getCurrentpage();
		System.out.println("currentpage:"+staffBean.getCurrentpage());
		Integer count = queryBizImp.addCount(staffBean);
		if (count == 0) {
			count =1 ;
		}
	    Integer totallPage = count % 5 > 0 ? count / 5 + 1 : count / 5;
		staffBean.setTotalPage(totallPage);
	//	staffBean.setCurrentpage(currentpage);
		String root = request.getServletContext().getRealPath("/upload"); // 设置文件的路径
		System.out.println("root:"+root);
		List<StaffBean> userList = queryBizImp.queryAll(staffBean);
		System.out.println("userList:"+userList.toString());
		System.out.println("staffBean:"+staffBean.toString());
		model.addAttribute("userList", userList);
		model.addAttribute("staffBean", staffBean);
		return "BackEnd/report_show";
		
	}
	
	
	
	//获取小结、展示小结
		@RequestMapping(value="showLittle.action")
		public ModelAndView showLittle(Model model,StaffBean staffBean) {
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
		
		
			mav.setViewName("BackEnd/query_summary");
			return mav;		
		}
	
		//获取总结
		@RequestMapping("/showSummary.action")
		public  String showSummary(Model model,String  guChId) {
			
			TotalBean totalBean = queryBizImp.showSummary(guChId);
			model.addAttribute("totalBean", totalBean);			
			return "BackEnd/query_allSummary";			
		}
		
		
		//展示报告列表
		@RequestMapping("/showFinalSummary.action")
		public  ModelAndView showFinalSummary(Model model,StaffBean staffBean) {
			ModelAndView mav  = new ModelAndView();
			//获得总结
			String guChId =staffBean.getMyGuChId(); //得到导检单ID
			TotalBean totalBean = queryBizImp.showSummary(guChId);
			//获得小结
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
			mav.addObject("totalBean", totalBean);
			mav.addObject("staffBean", staffBean);
			mav.setViewName("BackEnd/query_final_summary");
			return mav;			
		}
		
}
