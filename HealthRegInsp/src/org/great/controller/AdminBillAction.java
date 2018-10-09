package org.great.controller;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.RefundBean;
import org.great.biz.BillBiz;
import org.great.biz.RefundBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 后台账单管理 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-09 00:16 
*/ 
@Controller
@RequestMapping("/adminBillAction")
public class AdminBillAction {
	
	@Resource
	private RefundBiz refundBizImp;//退款记录接口
	
	@Resource
	private BillBiz bdminBizImp;//账单业务接口
	
	ModelAndView mav = new ModelAndView();
	
	/*
	 * @Description:查询后台账单(分页模糊查询) 
	* @return（展示方法参数和返回值）
	 */
	@RequestMapping("/showBill.action")
	public ModelAndView showBill(Model model,@RequestParam Integer page) {
		
		/*if(paramId.equals("1")) {
			paramId = "";
		}*/
		
		//调用插叙细项总数
		Integer sum = refundBizImp.selectRefundSum();
		
		model.addAttribute("sum", sum);
		
		Integer p = (int) Math.ceil(Double.valueOf(sum)/10);
		
		model.addAttribute("p", p);
		
		if(page<1) {
			page = 1;
		}else if(page>p){
			page = page - 1;
			
		}
		//调用模糊条件分页查询细项方法
		List<RefundBean> list = refundBizImp.selectRefund(page);
		
		model.addAttribute("list", list);
		
		/*if(paramId.equals("")) {
			paramId = "1";
		}*/
		
		/*model.addAttribute("role", role);*/
		model.addAttribute("page", page);
		mav.setViewName("BackEnd/AdminBill");
		
		return mav;	
		
	}

}
