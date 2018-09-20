/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.controller 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午9:54:59 
 */
package org.great.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.TotalBean;
import org.great.biz.ReportBiz;
import org.great.biz.ReportBizImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @ClassName: ReportAction 
 * @Description: 总结报告
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午9:54:59  
 */
@Controller
@RequestMapping("Report")
public class ReportAction {

	@Resource
	private TotalBean totalBean;  //总结类实体
	
	@Resource
	private ReportBiz reportBizImp;  //报告类接口
	
	@RequestMapping("showRepoert.action")	
	public String  showRepoert(HttpServletRequest request, Model model,TotalBean totalBean) {
		
		totalBean =  reportBizImp.showReport(totalBean.getGuChId());
		System.out.println("totalBean:"+totalBean.toString());
		return "user_report";
	}
}
