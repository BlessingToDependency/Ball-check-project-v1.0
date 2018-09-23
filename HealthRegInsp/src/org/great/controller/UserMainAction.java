package org.great.controller;
/*
 * 前台主页套餐展示
 */

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.SetmealBean;
import org.great.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

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
		System.out.println("套餐："+setmealId);
		List<SetmealBean> setList=userBizImp.showSetmeal(setmealId);
		int count = 0;
		for(int i=0;i<setList.size();i++) {
			SetmealBean sb = setList.get(i);
			System.out.println("套餐id:---"+sb.toString());
			int countAll = 0;
			for(int j =0;j<setList.get(i).getLitemBean().size();j++) {
				count = setList.get(i).getLitemBean().get(j).getPrice();
				countAll = countAll+count;
				System.out.println("第二层="+countAll);
			}
			sb.setCountAll(countAll);
		}  
		
		if(null != setmealId) {
			
			mav.setViewName("FrontEnd/commodity");
		}else {
			mav.setViewName("FrontEnd/user_index");
		}
		mav.addObject("setList", setList);
		return mav;
	}
}
