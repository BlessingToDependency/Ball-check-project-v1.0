package org.great.controller;

import javax.annotation.Resource;

import org.great.bean.LitemBean;
import org.great.biz.AdminBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 增加项目
 */
@Controller
@RequestMapping("/adminLitemAction")
public class AdminLitemAction {

	@Resource
	private AdminBiz adminBizImp;
	
	@Resource
	private LitemBean litemBean;
	

	ModelAndView mav = new ModelAndView();
	
	@RequestMapping("/addItem.action")
	public ModelAndView addItem(LitemBean litemBean) {
		
		adminBizImp.addItem(litemBean);//调用增加项目方法
		
		adminBizImp.selectLitem(litemBean);
		return mav;
		
	}
}
