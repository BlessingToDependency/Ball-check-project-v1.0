package org.great.controller;
/*
 * 前台主页套餐展示
 */

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.SetmealBean;
import org.great.bean.StaffMealBean;
import org.great.bean.UserBean;
import org.great.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


@Controller
@Scope("prototype")//每次获取Bean的时候会有一个新的实例
@RequestMapping("/userMainAction")
public class UserMainAction {

	@Resource
	private SetmealBean setmealBean;
	ModelAndView mav = new ModelAndView();
	@Resource
	private UserBiz userBizImp;//前台用户接口
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	//主页展示套餐
	@RequestMapping("showSetmeal.action")
	public ModelAndView showSetmeal(String setmealId) throws Exception{
		List<SetmealBean> setList=userBizImp.showSetmeal(setmealId);
		int count = 0;
		
		//计算价格
		for(int i=0;i<setList.size();i++) {
			SetmealBean sb = setList.get(i);
			int countAll = 0;
			for(int j =0;j<setList.get(i).getLitemBean().size();j++) {
				count = setList.get(i).getLitemBean().get(j).getPrice();
				countAll = countAll+count;
			}
			sb.setCountAll(countAll);
		}  
		if(null != setmealId) {
			
			mav.setViewName("FrontEnd/commodity");
		}else {
			mav.setViewName("FrontEnd/user_index");
		}
		System.out.println(setList.size());
		mav.addObject("setList", setList);
		return mav;
	}
	
	/*
	 * 为员工选择套餐
	 */
	@RequestMapping("chooseMeal.action")
	 public ModelAndView chooseMeal(String setmealId,String staffId){
		List<SetmealBean> setList=userBizImp.showSetmeal(setmealId);
		
		int count = 0;
		//计算价格
		for(int i=0;i<setList.size();i++) {
			SetmealBean sb = setList.get(i);
			int countAll = 0;
			StringBuffer strItem = new StringBuffer();
			for(int j =0;j<setList.get(i).getLitemBean().size();j++) {
				count = setList.get(i).getLitemBean().get(j).getPrice();//价格
				strItem.append(setList.get(i).getLitemBean().get(j).getItem());//项目
				strItem.append(";");
				countAll = countAll+count;
			}
			sb.setItemNick(strItem.toString());
			sb.setCountAll(countAll);
		}  
		//是否有套餐id
		if(null != setmealId) {
			mav.setViewName("FrontEnd/user_mealone");
		}else {
			mav.setViewName("FrontEnd/user_meallist");
		}
		System.out.println("员工id="+staffId);
		mav.addObject("staffId",staffId);//体检员工id
		mav.addObject("setList", setList);
		 
		return mav;
	 }
	
	/*
	 * 为某一位员工选择套餐:插入进关系表
	 */
	@RequestMapping("bespeakMeal.action")
	public ModelAndView bespeakMeal(StaffMealBean staffMealBean) {
		
		if(0 != staffMealBean.getStaffId()) {
			System.out.println(staffMealBean.toString());
			userBizImp.bespeakMeal(staffMealBean);
		}else {
			
			
		}
		return new ModelAndView("redirect:/fileAction/companyStaffList.action");
	}
	
	/*
	 * 现在购买:未完善
	 */
	@RequestMapping("buyNow.action")
	public ModelAndView buyNow(SetmealBean setmealBean) throws Exception{
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		if(null != userBean) {
			System.out.println("购买");
			mav.addObject("setmealBean", setmealBean);
			mav.setViewName("FrontEnd/user_buynow");
		}else {
			System.out.println("登陆去");
			mav.setViewName("FrontEnd/user_login");
		}
		return mav;
	}
	
	
}
