package org.great.controller;
/*
 * 前台主页套餐展示
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.PerguirelaBean;
import org.great.bean.SetmealBean;
import org.great.bean.ShoppingCartBean;
import org.great.bean.StaffBean;
import org.great.bean.StaffMealBean;
import org.great.bean.UserBean;
import org.great.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

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

	private List<ShoppingCartBean> shoppingList;//购物车list

	//立即预约:数量+套餐id
	@RequestMapping("orderDetails.action")
	public ModelAndView orderDetails(String cartNumber,String setmealId) {
		System.out.println("cartNumber="+cartNumber+"setmealId="+setmealId);
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
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
			sb.setNumber(Integer.parseInt(cartNumber));
		}  
		if(null != setmealId) {
			mav.setViewName("FrontEnd/user_purchase");
		}else {
			mav.setViewName("FrontEnd/user_index");
		}


		mav.addObject("setList", setList);
		mav.addObject("userBean", userBean);
		mav.setViewName("FrontEnd/user_details");
		return mav;
	}

	//我的购物车
	@RequestMapping("shoppingCart.action")
	@ResponseBody
	public List<ShoppingCartBean> shoppingCart(ShoppingCartBean shoppingCartBean) throws Exception{
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		//		PrintWriter out = response.getWriter();
		if(null != userBean) {
			int count = 0;

			shoppingList = userBizImp.shoppingCart(userBean.getCompanyId());//查询语句
			System.out.println("shoppingList="+shoppingList.size());
			for(int i=0;i<shoppingList.size();i++) {

				ShoppingCartBean scb = shoppingList.get(i);
				int countAll = 0;
				double discount = 0;
				String setmeal = null;
				String picture = null;
				for(int j=0;j<shoppingList.get(i).getSetmealBean().size();j++) {
					discount = shoppingList.get(i).getSetmealBean().get(j).getDiscount();
					setmeal = shoppingList.get(i).getSetmealBean().get(j).getSetmeal();
					picture = shoppingList.get(i).getSetmealBean().get(j).getPicture();
					for(int z=0;z<shoppingList.get(i).getSetmealBean().get(j).getLitemBean().size();z++) {
						count = shoppingList.get(i).getSetmealBean().get(j).getLitemBean().get(z).getPrice();
						countAll = countAll+count;
					}
					System.out.println(discount);
					scb.setDiscount(discount);
				}

				System.out.println("countAll="+countAll);
				scb.setCountAll(countAll);
				scb.setSetmeal(setmeal);
				scb.setPicture(picture);
			}

		}else {
			System.out.println("查询购物车登陆去");
			return null;
		}
		return shoppingList;
	}
	//加入购物车
	@RequestMapping("addShoppingCart.action")
	public ModelAndView addShoppingCart(ShoppingCartBean shoppingCartBean)throws Exception {
		System.out.println("进入");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		if(null != userBean) {
			System.out.println("加入购物车");
			shoppingCartBean.setCompanyId(userBean.getCompanyId());//当前公司id
			System.out.println(shoppingCartBean.getSetmealId()+"---"+shoppingCartBean.getAcrtNumber());
			//插入购物车
			userBizImp.addShoppingCart(shoppingCartBean);
			String strCon = gson.toJson(1);
			out.print(strCon);
		}else {
			String strCon = gson.toJson(2);
			out.print(strCon);
			System.out.println("加入购物车登陆去");
			mav.setViewName("FrontEnd/user_login");
		}
		out.close();
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
			mav.setViewName("FrontEnd/user_purchase");
		}else {
			//			mav.addObject("shoppingList", shoppingList);
			mav.setViewName("FrontEnd/user_index");
		}
		System.out.println(setList.size());
		mav.addObject("setList", setList);
		return mav;
	}

	/*
	 * 批量为员工选择套餐
	 */
	@RequestMapping("batchMeal.action")
	public ModelAndView batchMeal(String setmealId,String[] staffId) {
		//查询当前公司下所有未预约套餐得人员
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");

		List<StaffBean> staffList = userBizImp.batchMeal(userBean.getCompanyId());
		System.out.println("staffList="+staffList.size());

		//展示套餐
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
			mav.setViewName("FrontEnd/user_batch_mealone");
		}else {
			mav.setViewName("FrontEnd/user_batch_meal");
		}
		
		System.out.println("setmealId=="+setmealId);
		System.out.println("staffId=="+staffId);
		
		mav.addObject("staffList",staffList);//未预约的员工list
		mav.addObject("staffId",staffId);//未预约的员工id
		mav.addObject("setList",setList);//套餐

		return mav;
	}
	
	

	/*
	 * 单独为员工选择套餐
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
	public ModelAndView bespeakMeal(PerguirelaBean perguirelaBean,StaffMealBean staffMealBean,String[] staffId) {
		System.out.println(staffMealBean.toString());//套餐id:setmealId
		System.out.println(perguirelaBean.toString());//员工id：staffId
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		perguirelaBean.setCompanyId(userBean.getCompanyId());//公司id
		perguirelaBean.setBatchNum(1);//批次
		
		if(staffId.length!=0) {
			for(int i=0;i<staffId.length;i++) {
				//修改当前员工预约状态
				perguirelaBean.setStaffId(Integer.parseInt(staffId[i]));
				userBizImp.updateState(perguirelaBean);
				//需要当前员工id
				staffMealBean.setStaffId(perguirelaBean.getStaffId());
				//人员套餐关系表
				userBizImp.bespeakMeal(staffMealBean);
			}
			
		}else {

		//修改当前员工预约状态
		userBizImp.updateState(perguirelaBean);

		//需要当前员工id
		staffMealBean.setStaffId(perguirelaBean.getStaffId());
		//人员套餐关系表
		userBizImp.bespeakMeal(staffMealBean);
		}
		return new ModelAndView("redirect:/fileAction/companyStaffList.action");
	}

	/*
	 * 现在购买:未完善;搁置
	 */
	@RequestMapping("testbuy.action")
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
