package org.great.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.great.bean.AdminBean;
import org.great.bean.DeparBean;
import org.great.bean.FinresultBean;
import org.great.bean.LitemBean;
import org.great.bean.SetmealBean;
import org.great.bean.TermBean;
import org.great.biz.AdminBiz;
import org.great.biz.ISummaryBiz;
import org.great.search.GuchIDdItemID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
/*
 * 科室医生体检处理
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
@Controller
@RequestMapping("doctorAction")
public class DoctorAction {
	
	private List<TermBean> termList;
	
	@Resource
	private SetmealBean setmealBean;//套餐表
	ModelAndView mav = new ModelAndView();
	@Resource
	private AdminBiz adminBizImp;//后台接口
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	@Resource
	private ISummaryBiz SummaryBizImp;
	
	//跳转科室医生查询界面
	@RequestMapping("/doctorMain.action")
	public ModelAndView doctorMain() {
		//判断该登录的医生属于哪个科室
		//得到登录对象信息
		AdminBean adminBean = (AdminBean) request.getSession().getAttribute("adminBean");
		//得到对应的科室Id
		int depaId = adminBean.getDepaId();
		//获取该科室体检的项目
	    LitemBean item= SummaryBizImp.getItem(depaId);
		//得到科室信息
		DeparBean depar = adminBizImp.getIntfaceId(depaId);
		//得到科室对应的体检界面
		int intf = depar.getIntfaceId();
		if(intf==102) {
			//获取数据用户小结记录
			GuchIDdItemID giBean=new  GuchIDdItemID();
			giBean.setItemId(item.getItemId());
			giBean.setDoctor(adminBean.getAdminName());
			giBean.setItem(item.getItem());
			request.setAttribute("giBean", giBean);
			mav.setViewName("BackEnd/MedicalImage");
		}else {
			mav.setViewName("BackEnd/doctormain");
		}
		return mav;
	}
	
	//通过导检单id和科室id查询细项
	@RequestMapping(value="/selectSetmeal.action",
			produces="application/json;charset=utf-8")
	@ResponseBody
	public void selectSetmeal(String guChId)throws Exception{
		System.out.println("guChId="+guChId);
		//当前登陆医生
		AdminBean ab = (AdminBean) request.getSession().getAttribute("adminBean");
		//获取到科室细项值
		termList = adminBizImp.selectSetmeal(guChId,ab.getDepaId());
		//回传数据
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String str = gson.toJson(termList);
		out.print(str);
		out.close();
		System.out.println(termList);
//		return termList;
	} 
	
	//插入体检结果信息
	@RequestMapping("/addFinresult.action")
	public ModelAndView addFinresult(FinresultBean finresultBean,@RequestParam String [] termId,@RequestParam String [] termVal) {
		AdminBean ab = (AdminBean) request.getSession().getAttribute("adminBean");
		System.out.println("导检单="+finresultBean.getGuChId());//导检单id
		int itemId = adminBizImp.selectItem(finresultBean.getGuChId(),ab.getDepaId());//项目id
		System.out.println(itemId);
		finresultBean.setItemId(itemId);//项目id放进bean
		
		for(int j=0;j<termId.length;j++) {
			System.out.println("细项id="+termId[j]);
			System.out.println("细项值="+termVal[j]);
			finresultBean.setTermId(Integer.parseInt(termId[j]));//细项id
			finresultBean.setTermVal(termVal[j]);
			adminBizImp.addFinresult(finresultBean);
		}
		return mav;
	}	
}
