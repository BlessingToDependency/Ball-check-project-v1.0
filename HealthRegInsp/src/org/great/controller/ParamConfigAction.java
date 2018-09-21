package org.great.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.ParamBean;
import org.great.bean.UserBean;
import org.great.biz.IMissInspBiz;
import org.great.biz.IParamConfigBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
/*
 * 后台参数配置
 */
@Controller
@RequestMapping("/adminParamAction")
public class ParamConfigAction {   
	@Autowired
	private HttpServletResponse response;
	
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
	
	//删除系统参数
	@RequestMapping(value="/delParam.action")
	public ModelAndView DelParam(HttpServletRequest request,int pid){
		//对该参数进行删除操作
		int res=ParamConfigBizImp.DelParam(pid);
		ModelAndView mav = new ModelAndView();
		if(res>0) {
			return new ModelAndView("redirect:/adminParamAction/systemParam.action");
		}
		return mav;
	}
	
	//修改系统参数
	@RequestMapping(value="/updateParam.action")
	public ModelAndView UpdateParam(HttpServletRequest request,int pid){
		//得到该参数信息
		ParamBean pb = ParamConfigBizImp.getParamInfo(pid);
		try {
			PrintWriter out =response.getWriter();
			//通过gson进行传输
			Gson gson=new Gson();
			String msg=gson.toJson(pb);
			out.print(msg);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//保存修改的系统参数
	@RequestMapping(value="/saveParam.action")
	public ModelAndView SaveParam(HttpServletRequest request,String param,String parId,String coun){
		//修改参数信息

		System.out.println(coun);
		/*int res = ParamConfigBizImp.updateParam(param);
		ModelAndView mav = new ModelAndView();
		if(res>0) {
			return new ModelAndView("redirect:/adminParamAction/systemParam.action");
		}*/
		return null;
	}

}
