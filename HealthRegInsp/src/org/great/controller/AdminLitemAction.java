package org.great.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.great.bean.LitemBean;
import org.great.biz.AdminBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

/*
 * 项目管理
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
	public ModelAndView addItem() {
		
		adminBizImp.addItem(litemBean);//调用增加项目方法
		

		return mav;
		
	}
	/*
	 * 首页查询项目
	 */
	@RequestMapping("/selectItem.action")
	public ModelAndView selectItem(HttpServletRequest request,Model model) {
		String peakPrice = "";
		String bottomPrice = "";
		String rank = "";
		Integer page = 1;
		
		

		//调用查询项目方法
		List<LitemBean> list = adminBizImp.selectLitem(litemBean, peakPrice, bottomPrice, rank, page);
		
		//调用SpingMVC的封装方法  和request的返回方法一致
		model.addAttribute("list", list);
		
		//查询项目的总数
		Integer sum = adminBizImp.selectLitemSum(litemBean, peakPrice, bottomPrice);
		
		model.addAttribute("sum", sum);
				
		mav.setViewName("BackEnd/admin_Item");
		
		return mav;
	}
	/*
	 *查看项目详情
	 */
	@RequestMapping(value="/activity.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> Activity(Model model,LitemBean litemBean,HttpServletResponse response) {
		//Map<String,Object> maps = new Hashtable<String, Object>();
		System.out.println(litemBean.getItemId());
		
		String peakPrice = "";
		String bottomPrice = "";
		String rank = "";
		Integer page = 1;
		
		//调用查询项目方法
		List<LitemBean> list = adminBizImp.selectLitem(litemBean, peakPrice, bottomPrice, rank, page);
		
//		System.out.println(list.toString());
		
		Map<String,Object> maps = new HashMap<String, Object>();
		
		maps.put("list", list);
//		maps.put("page", 1);
		
		
		
		return maps;
	}
}
