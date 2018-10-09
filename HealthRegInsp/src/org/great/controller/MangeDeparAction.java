package org.great.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.DeparBean;
import org.great.bean.ParamBean;
import org.great.biz.IdeparBiz;
import org.great.core.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/*
 * 管理科室
 */
@Controller
@RequestMapping("/maDeparAction")
public class MangeDeparAction {
	
	@Resource
	private IdeparBiz deparImp;
	@Resource 
	private  DeparBean  deparBean;
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private  HttpSession session;
	@Autowired
	private ServletConfig config;
	@Autowired
	private ServletContext servletContext;
	
	ModelAndView mav = new ModelAndView();
	
	/*
	 * 查询科室
	 */
	@RequestMapping(value="selectDe.action")

	public ModelAndView selectDe() {
		String page=request.getParameter("page");
		String depa=request.getParameter("depa");
		
		 int pageNo=-1;
			if(null==page||"".equals(page)) {
				pageNo =1;
				
			}else {
				pageNo = Integer.parseInt(page);
				
			}
			deparBean.setDepa(depa);
		List<DeparBean> depLi=deparImp.selectDeN(deparBean);
		int num=depLi.size();
		int paNum=0;	
		if(num%5==0) {
			paNum=num/5;
		}
		if(num%5!=0) {
			paNum=num/5+1;
	   }
		
		 
		int start = 5*pageNo-5; 
		int pagesize =5;
		RowBounds rowBounds = new RowBounds(start,pagesize);
		
		List<DeparBean> deli=deparImp.selectDe(deparBean, rowBounds);
		
		mav.addObject("page", pageNo);
		mav.addObject("paNum", paNum);	
		mav.addObject("depa", depa);
		//session.setAttribute("deli", deli);
		mav.addObject("deli", deli);
		mav.setViewName("BackEnd/mange_depar");
		return mav;
		
	}
	
	/*
	 * 跳转到增加科室界面
	 */
	@RequestMapping(value="toAddDepar.action")
	
	public @ResponseBody void toAddDepar ()throws Exception {
		List<ParamBean> parList=deparImp.selectX();
		PrintWriter out = response.getWriter();
		Gson gson1 = new Gson();
		String str1 = gson1.toJson(parList);
		out.print(str1);
		out.close();
		
	}
	
	/*
	 * 增加科室
	 */
	@RequestMapping(value="innserDepar.action")
	@ResponseBody
	@SystemLog(module="科室管理",methods="增加科室")
	public ModelAndView innserDepar(String depa,int intfaceId) {
		System.out.println("科室"+depa+"id=="+intfaceId);
		String msg=(String) session.getAttribute("msg");
		if(msg.equals("可用科室")) {
		
			deparImp.innserDepar(depa,intfaceId);
		mav.setViewName("redirect:/maDeparAction/selectDe.action");
		}
		else {
		
			mav.setViewName("redirect:/maDeparAction/selectDe.action");
		}
		return mav;
		
	}
	
	/*
	 * 删除科室
	 */
	@RequestMapping(value="deleteDepar.action")
	@ResponseBody
	@SystemLog(module="科室管理",methods="删除科室")
	public ModelAndView deleteDepar() {
		String de=request.getParameter("depaId");
	
		int depaId=Integer.parseInt(de);
		deparImp.deleteDepar(depaId);
		return new ModelAndView("redirect:/maDeparAction/selectDe.action");
		
	}
	
	/*
	 * 跳转到修改科室界面
	 */
	@RequestMapping(value="toUpdateDepar.action")
	public @ResponseBody void toUpdateDepar() throws Exception {
		
		String dei=request.getParameter("depId");
		int depi=Integer.parseInt(dei);
		session.setAttribute("dei", dei);
		PrintWriter out = response.getWriter();
		DeparBean dep=deparImp.selectnfo(depi);
		
		
		Gson gson1 = new Gson();
		String str1 = gson1.toJson(dep);
		out.print(str1);
		out.close();	
	}
	
	/*
	 * 修改科室名
	 */
	@RequestMapping(value="updateDepar.action")
	@ResponseBody
	@SystemLog(module="科室管理",methods="修改科室")
	public ModelAndView updateDepar(DeparBean  deparBea) {
		String dep=(String) session.getAttribute("dei");
		
		int depaId=Integer.parseInt(dep);
		deparBea.setDepaId(depaId);
		String msg=(String) session.getAttribute("msg");
		if(msg.equals("可用科室")) {
			System.out.println("1");
		deparImp.updateDepar(deparBea);
		mav.setViewName("redirect:/maDeparAction/selectDe.action");
		}else {
			System.out.println("2");
			mav.setViewName("redirect:/maDeparAction/selectDe.action");
		}
		
		return mav;		
	}
	
	/*
	 * 新增查重
	 */
	@RequestMapping(value="checkDepar.action")
	public @ResponseBody void checkDepar() throws Exception {
	
		String depar=request.getParameter("depa");
	      
		deparBean.setDepa(depar);
		List<DeparBean> deLi=deparImp.selectDeChe(deparBean);
	
		PrintWriter out = response.getWriter();
		String msg;
		if(deLi.size()>0||depar==null||"".equals(depar)) {
			msg="不可用科室";
			
		}else {
			msg="可用科室";
		}
		session.setAttribute("msg", msg);
		Gson gson1 = new Gson();
		String str1 = gson1.toJson(msg);
		out.print(str1);
		out.close();

	}
}
