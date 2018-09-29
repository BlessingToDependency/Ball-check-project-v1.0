package org.great.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.LogBean;
import org.great.biz.ILogBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/logAction")
public class LogAction {
	@Resource
	private  ILogBiz  logBizImp;

	
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
	
	//查询日志
	@RequestMapping("/selectAllLog.action")
	public ModelAndView selectAllLog(LogBean logBean) {
		System.out.println("zzzzzzzzz"+logBean.getName());
		String page=request.getParameter("page");
		String name=request.getParameter("name");
	/*	String startD=request.getParameter("start");
		String endD=request.getParameter("end");*/
	/*	logBean.setStart(startD);
		logBean.setEnd(endD);
		System.out.println(startD+"--"+endD);*/
		logBean.setName(name);
		 int pageNo=-1;
			if(null==page||"".equals(page)) {
				pageNo =1;
				
			}else {
				pageNo = Integer.parseInt(page);
				
			}
		int start = 10*pageNo-10; 
		int pagesize =10;
		RowBounds rowBounds = new RowBounds(start,pagesize);
            
		List<LogBean> logList=logBizImp.selectAllLog(rowBounds, logBean);
		List<LogBean> logLi=logBizImp.selectLogNu(logBean);
		int num=logLi.size();
		int paNum=0;	
		if(num%10==0) {
			paNum=num/10;
		}
		if(num%10!=0) {
			paNum=num/10+1;
	   }

		session.setAttribute("logList", logList);
		mav.setViewName("BackEnd/log");
		mav.addObject("page", pageNo);
		mav.addObject("paNum", paNum);	
		return mav;
		
	}
	
	//删除日志
	@RequestMapping("/deleteLog.action")
	public ModelAndView deleteLog() {
		String l=request.getParameter("logId");
		int logId=Integer.parseInt(l);
		logBizImp.deleteLog(logId);
		mav.setViewName("redirect:/logAction/selectAllLog.action");
		return mav;
		 
	}
	
	//批量删除日志
	@RequestMapping(value="/batchDel.action")
	public ModelAndView batchDel(HttpServletRequest request,String[] data){
		System.out.println(data);
		for(int i=0;i<data.length;i++) {
			int logId = Integer.parseInt(data[i]);
			logBizImp.deleteLog(logId);
			
		}
		return new ModelAndView("redirect:/logAction/selectAllLog.action");
	}
}
