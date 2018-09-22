package org.great.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 后台管理员管理
 */
@Controller
@RequestMapping("/adminManagerAction")
public class AdminManagerAction {   
	@Autowired
	private HttpServletResponse response;
	
	@Resource
	private IParamConfigBiz ParamConfigBizImp;
	//获取系统参数数据
	@RequestMapping(value="/systemParam.action")
	public ModelAndView BackLogin(HttpServletRequest request,Integer pageNo){
		int page=0;               //定义当前页
		int statrRn=0;            //定义开始显示的记录序列
		int endRn = 0;            //定义结束显示的记录序列
		String pno = pageNo+"";   //转换成String
		if("null".equals(pno) || "".equals(pno)){
			page=1;
			statrRn = page*5;
			endRn = page*5-4;
		}else{
			int pageNs = Integer.parseInt(pno);   //转换成Int类型
			page=pageNs;
			statrRn = page*5;
			endRn = page*5-4;
		}
		//得到展示的数据List
		List<ParamBean> paramList=ParamConfigBizImp.ParamList(statrRn,endRn);
		//得到总数据
		List<ParamBean> allParamList=ParamConfigBizImp.allParamList();
		//获得页码
		int allRecord=allParamList.size();
		int AllPage=0;
		if(allRecord!=0) {
			if(allRecord%5!=0) {
				AllPage=(allRecord/5)+1;
			}else {
				AllPage=(allRecord/5);
			}
		}else {
			AllPage=1;
		}
		//展示的列表
		request.setAttribute("paramList", paramList);
		//当前页数
		request.setAttribute("pageNo", page);
		//总的页数
		request.setAttribute("AllPage", AllPage);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BackEnd/ParamList");
		return mav;
	}
	
	//添加系统参数
		@RequestMapping(value="/addParam.action")
		public ModelAndView DelParam(HttpServletRequest request,String param,int conname){
			//对该参数进行添加操作
			ParamBean params = new ParamBean();
			params.setParam(param);
			params.setParId(conname);
			int res=ParamConfigBizImp.addParam(params);
			ModelAndView mav = new ModelAndView();
			if(res>0) {
				return new ModelAndView("redirect:/adminParamAction/systemParam.action");
			}
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
		//定义一个Map
		Map<ParamBean,List<ParamBean>> map = new HashMap<ParamBean,List<ParamBean>>();
		//得到该参数信息
		ParamBean pb = ParamConfigBizImp.getParamInfo(pid);
		//得到该参数信息
		List<ParamBean> piList = ParamConfigBizImp.allParamPar();
		//得到对应父级菜单名
		//赋值
		map.put(pb, piList);
		try {
			PrintWriter out =response.getWriter();
			//通过gson进行传输
			Gson gson=new Gson();
			String msg=gson.toJson(map);
			out.print(msg);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//获得所有的父级参数
	@RequestMapping(value="/getParam.action")
	public ModelAndView GetParamPar(HttpServletRequest request,int pid){
		//得到该参数信息
		List<ParamBean> piList = ParamConfigBizImp.allParamPar();
				try {
					PrintWriter out =response.getWriter();
					//通过gson进行传输
					Gson gson=new Gson();
					String msg=gson.toJson(piList);
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
	public ModelAndView SaveParam(HttpServletRequest request,String pn,String paramId,String co){
		//修改参数信息
		System.out.println(co);
		/*int res = ParamConfigBizImp.updateParam(param);
		ModelAndView mav = new ModelAndView();
		if(res>0) {
			return new ModelAndView("redirect:/adminParamAction/systemParam.action");
		}*/
		return null;
	}

}
