package org.great.controller;
/*
 * 前台主页套餐展示
 */

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.PerguirelaBean;
import org.great.bean.SetmealBean;
import org.great.bean.ShoppingCartBean;
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
	
	
	//我的购物车
	@RequestMapping("shoppingCart.action")
	public ModelAndView shoppingCart(ShoppingCartBean shoppingCartBean) {
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		if(null != userBean) {
			System.out.println("购物车");
			userBean.getCompanyId();//当前公司id
			
			mav.setViewName("FrontEnd/");
		}else {
			System.out.println("登陆去");
			mav.setViewName("FrontEnd/user_login");
		}
		return mav;
	}
	//加入购物车
	@RequestMapping("addShoppingCart.action")
	public ModelAndView addShoppingCart(ShoppingCartBean shoppingCartBean) {
		System.out.println("进入");
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		if(null != userBean) {
			System.out.println("加入购物车");
			userBean.getCompanyId();//当前公司id
			System.out.println(shoppingCartBean.getSetmealId()+"---"+shoppingCartBean.getCartNumber());
			//插入购物车
			userBizImp.addShoppingCart(shoppingCartBean);
			
			mav.setViewName("FrontEnd/");
		}else {
			System.out.println("登陆去");
			mav.setViewName("FrontEnd/user_login");
		}
		return mav;
	}
	
	
	//主页展示套餐
	@RequestMapping("showSetmeal.action")
	public ModelAndView showSetmeal(String setmealId) throws Exception{
		List<SetmealBean> setList=userBizImp.showSetmeal(setmealId);
		int count = 0;
		
		//计算价格
		for(int i=0;i<setList.size();i++) {
			SetmealBean sb = setList.get(i);
			int countAll = 0;
			StringBuffer strItem = new StringBuffer();
			for(int j =0;j<setList.get(i).getLitemBean().size();j++) {
				count = setList.get(i).getLitemBean().get(j).getPrice();
				strItem.append(setList.get(i).getLitemBean().get(j).getItem());//项目
				strItem.append(";");
				countAll = countAll+count;
			}
			sb.setItemNick(strItem.toString());
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
	public ModelAndView bespeakMeal(PerguirelaBean perguirelaBean,StaffMealBean staffMealBean) {
		System.out.println(staffMealBean.toString());
		System.out.println(perguirelaBean.toString());
		//导检单id=0为个人选择套餐；！=0未为团队选择套餐
//		if(0 != staffMealBean.getPerInspId()) {
			UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
			
			perguirelaBean.setCompanyId(userBean.getCompanyId());//公司id
			perguirelaBean.setBatchNum(1);//批次
			
			
			
			//修改当前员工预约状态
			userBizImp.updateState(perguirelaBean);
			
			//人员套餐关系表
			userBizImp.bespeakMeal(staffMealBean);
//		}else {
//			//团队选择套餐
//		}
		return new ModelAndView("redirect:/fileAction/companyStaffList.action");
	}
	
	/*
	 * 现在购买:未完善;搁置
	 */
	@RequestMapping("/testbuy.action")
	public ModelAndView buyNow(SetmealBean setmealBean) throws Exception{
		System.out.println("立即预约");
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
