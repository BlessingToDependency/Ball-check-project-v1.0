/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.controller 
 * @author: wjx(wangj)   
 * @date: 2018年10月1日 上午10:40:38 
 */
package org.great.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.SetmealBean;
import org.great.bean.TblChannel;
import org.great.bean.TblStatistics;
import org.great.bean.TotalBean;
import org.great.biz.StatisitcBiz;
import org.great.tools.DateSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/** 
 * @ClassName: StatisticsAction 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月1日 上午10:40:38  
 */
@Controller
@RequestMapping("/Statistic")
public class StatisticsAction {

	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private HttpSession session;
	
	@Autowired 
	private ServletConfig config;
	
	@Autowired
	private ServletContext servletContext;
	private TblStatistics sta;
	@Resource
	private StatisitcBiz  statisitcBizImp;
	
	
	
	@RequestMapping("/showBar.action")
	public String showBar(){
		
		return "BackEnd/admin_bargraph";		
	}
	
	
	
	
	
	//计算一周的注册人数
	@RequestMapping("/showWeek.action")
	@ResponseBody
	public void showWeek() throws IOException {
		
		PrintWriter out = response.getWriter();
		TblStatistics[] obj = new TblStatistics[7];
		List<String> listWeek = DateSet.getWeek();
		setTime(obj, listWeek, 7);		
	}
	
    //计算一个月的注册人数
	@RequestMapping("/showMonth.action")
	@ResponseBody
	public void   showMonth() throws IOException {

		List<String> getMonth  =DateSet.getMount();  //得到月份
		TblStatistics  tblMonth[]  = new TblStatistics[getMonth.size()-1];			
		setTime(tblMonth, getMonth,1);
	}
	
	//计算三个月的注册人数
	@RequestMapping("/showSeason")
	@ResponseBody
	public void  showSeason() throws IOException {
		List<String> seaSon =DateSet.getQuarter(); //得到季度
		TblStatistics  tblSeason[]  = new TblStatistics[seaSon.size()-1];		
		setTime(tblSeason, seaSon, 3);
	}
	
	@RequestMapping("/showCh.action")	
	public String  showRepoert( Model model,TotalBean totalBean) {
			
		return "BackEnd/user_report_summary";
	}

	//统计套餐
	@RequestMapping("/showChannel.action")
	public String showChannel(Model model,TblChannel channel) {
		//接收套餐信息
		Gson gson = new Gson();
		List<SetmealBean> order = statisitcBizImp.queryOrder(channel);
		System.out.println("order:"+order.toString());
		List<TblChannel> channelist = new ArrayList<TblChannel>();
		String before = channel.getBefore();
		String after = channel.getAfter();
		
	
		
		for (int i = 0; i < order.size(); i++) {
		    TblChannel myChannel = new TblChannel();
			myChannel.setBefore(before);
			myChannel.setAfter(after);
			String orderName = order.get(i).getSetmeal();
			myChannel.setOrderName(orderName);
			Integer orderCount = statisitcBizImp.orderCount(myChannel);
			myChannel.setOrderCount(orderCount);
			channelist.add(myChannel);
			System.out.println("myChannel:"+myChannel.toString());
			System.out.println(orderCount+"--"+orderName);
		}
		System.out.println("channelist:"+channelist.toString());
		String 	contan = gson.toJson(channelist);
		model.addAttribute("contan", contan);
		model.addAttribute("channel", channel);		
		return "BackEnd/admin_user_statistics";				
	}
	
	
	
	
	private void setTime(TblStatistics[] obj ,List<String>listWeek,int date ) throws IOException {
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		for (int i = 0; i < listWeek.size()-1; i++) {
			String[] color = {"#360", "#f30", "#06c", "#87CEFA", "#7FFFAA", " #556B2F", "#FFD700"};
			String colorAll= color[i];
			System.out.println(listWeek.get(i));
			sta = new TblStatistics(listWeek.get(i), listWeek.get(i+1));
			int count =statisitcBizImp.getCount(sta); //查询一周的注册量
			
			if (date == 7) {
				TblStatistics  countUser  =  new  TblStatistics(setWeek(i + 1),count,colorAll);
				obj[i] = countUser;
			}
			if (date == 1) {
				TblStatistics  countUser  =new  TblStatistics(setMonth(i + 1), count ,colorAll);
				obj[i] = countUser;
			}
			if (date == 3) {
				TblStatistics  countUser  = new  TblStatistics(setSeason(i + 1), count ,colorAll);
				obj[i] = countUser;
			}
		}
		String string  = gson.toJson(obj);
		out.print(string);
		out.close();
	}



	public  String setWeek(int x ) {
		
		String str = null;
		if (x==1) {
			str = "周一";
		}else if (x ==2) {
			str ="周二";
		}else if (x ==3) {
			str ="周三";
		}else if (x == 4) {
			str = "周四";
		}else if (x == 5) {
			str = "周五";
		} else if (x == 6) {
			str = "周六";
		} else if (x == 7) {
		   str = "周日";
		}
		
		return str;	
	}

	public String setMonth(int x) {
		String str = null;
		if (x == 1) {
			str = "第一周";
		} else if (x == 2) {
			str = "第二周";
		} else if (x == 3) {
			str = "第三周";
		} else if (x == 4) {
			str = "第四周";
		} else if (x == 5) {
			str = "第五周";
		} else if (x == 6) {
			str = "第六周";
		}
		return str;
	}

	public String setSeason(int x) {
		String str = null;
		if (x == 1) {
			str = "第一个月";
		} else if (x == 2) {
			str = "第二个月";
		} else if (x == 3) {
			str = "第三个月";
		}
		return str;
	}
	
	
	
	
	/**
	 * @return the sta
	 */
	public TblStatistics getSta() {
		return sta;
	}





	/**
	 * @param sta the sta to set
	 */
	public void setSta(TblStatistics sta) {
		this.sta = sta;
	}
}
