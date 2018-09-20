package org.great.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.ParamBean;
import org.great.bean.UserBean;
import org.great.biz.IMissInspBiz;
import org.great.biz.IParamConfigBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 * 后台参数配置
 */
@Controller
@RequestMapping("/adminParamAction")
public class ParamConfigAction {    
	
	@Resource
	private IParamConfigBiz ParamConfigBizImp;
	//获取系统参数数据
	@RequestMapping(value="/systemParam.action")
	public ModelAndView BackLogin(HttpServletRequest request){
		//调用业务层
		List<ParamBean> paramList=ParamConfigBizImp.ParamList();
		request.setAttribute("paramList", paramList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BackEnd/ParamList");
		return mav;
	}

}
