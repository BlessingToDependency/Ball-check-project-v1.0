package org.great.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.AdminBean;
import org.great.bean.FinresultBean;
import org.great.bean.LitemBean;
import org.great.bean.ParamBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.biz.IAdminMangerBiz;
import org.great.biz.IMissInspBiz;
import org.great.biz.IParamConfigBiz;
import org.great.biz.ISummaryBiz;
import org.great.search.AdminCon;
import org.great.search.GuchIDdItemID;
import org.great.search.SumCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
/*
 * 医生小结
 */
@Controller
@RequestMapping("/doctorSummaryAction")
public class SummaryAction {   
	@Autowired
	private HttpServletResponse response;
	
	@Resource
	private ISummaryBiz SummaryBizImp;
	//获取对应科室已经体检完的用户信息
	@RequestMapping(value="/getThisItemStaff.action")
	public ModelAndView getStaffList(HttpServletRequest request,SumCon sunCon,Integer pageNo){
		int page=0;//当前页初始值
		String pno = pageNo+"";   //转换成String
		if("null".equals(pno) || "".equals(pno)){
			page=1;
			sunCon.setStatrRn(page*5);
			sunCon.setEndRn(page*5-4);
		}else{
			page = Integer.parseInt(pno);   //转换成Int类型
			sunCon.setStatrRn(page*5);
			sunCon.setEndRn(page*5-4);
		}	
		//获取对应项目的体检项目
		List<StaffBean> thisItemlist=SummaryBizImp.getSummaryList(request,sunCon);
		List<StaffBean> allthisItemlist = SummaryBizImp.getAllSummaryList(request, sunCon);
		//获得页码
		int allRecord=allthisItemlist.size();
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
		//搜索条件
		request.setAttribute("sunCon", sunCon);
		//展示的列表
		request.setAttribute("thisItemlist", thisItemlist);
		//当前页数
		request.setAttribute("pageNo", 1);
		//总的页数
		request.setAttribute("AllPage", 1);
		//总的记录数
		request.setAttribute("allRecord", allRecord);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BackEnd/ThisItemStaffList");
		return mav;
	}
	
	//进行小结
	@RequestMapping(value="/makeSummary.action")
	public ModelAndView Summary(HttpServletRequest request,String guChId){
		//得到登录对象信息
		AdminBean adminBean = (AdminBean) request.getSession().getAttribute("adminBean");
		//得到对应的科室ID
		int depeId =adminBean.getDepaId();
		//根据科室跳转到不同的小结页面
		int incFace = SummaryBizImp.intFace(depeId);
		//获取该科室体检的项目
	    LitemBean item= SummaryBizImp.getItem(depeId);
		ModelAndView mav = new ModelAndView();
		//这是进行影像小结
		if(incFace==102) {
			//获取数据用户小结记录
			GuchIDdItemID giBean=new  GuchIDdItemID();
			giBean.setGuChId(guChId);
			giBean.setItemId(item.getItemId());
			giBean.setDoctor(adminBean.getAdminName());
			giBean.setItem(item.getItem());
			request.setAttribute("giBean", giBean);
			//根据导检单号以及项目ID找到对应图片
			List<String> fileNameList= SummaryBizImp.imageFile(giBean.getGuChId(), giBean.getItemId());
			request.setAttribute("fileNameList", fileNameList);
			mav.setViewName("BackEnd/ImageSumm");
		}
		//这是进行检验小结
		else if(incFace==103) {
			//获取该体检人员该项目中的体检项目中的细项结果
			List<FinresultBean> finrList = SummaryBizImp.getFinresultList(guChId, item.getItemId());
			//展示的细项结果
			request.setAttribute("finrList", finrList);
			//获取数据用户小结记录
			GuchIDdItemID giBean=new  GuchIDdItemID();
			giBean.setGuChId(guChId);
			giBean.setItemId(item.getItemId());
			giBean.setDoctor(adminBean.getAdminName());
			giBean.setItem(item.getItem());
			request.setAttribute("giBean", giBean);
			
			mav.setViewName("BackEnd/TestSumm");
		}
		//这是进行普通小结
		else {
			//获取该体检人员该项目中的体检项目中的细项结果
			List<FinresultBean> finrList = SummaryBizImp.getFinresultList(guChId, item.getItemId());
			//展示的细项结果
			request.setAttribute("finrList", finrList);
			//获取数据用户小结记录
			GuchIDdItemID giBean=new  GuchIDdItemID();
			giBean.setGuChId(guChId);
			giBean.setItemId(item.getItemId());
			giBean.setDoctor(adminBean.getAdminName());
			giBean.setItem(item.getItem());
			request.setAttribute("giBean", giBean);
			
			mav.setViewName("BackEnd/OrdinarySumm");
		}
		return mav;
	}
	
	//影像小结获得影像图片
	@RequestMapping(value="/getImage.action")
	
	public ModelAndView getImage(HttpServletRequest request,HttpServletResponse response,String fileName,String guChId){
		String root = request.getServletContext().getRealPath("/upload/"+guChId+"/"); // 设置文件的路径
			File file=new File(root + fileName);
			try {
				InputStream inputStream=new FileInputStream(file);
				OutputStream output = response.getOutputStream();// 得到输出流
				
				BufferedInputStream bis = new BufferedInputStream(inputStream);// 输入缓冲流
				BufferedOutputStream bos = new BufferedOutputStream(output);// 输出缓冲流
				byte data[] = new byte[4096];// 缓冲字节数
				int size = 0;
				size = bis.read(data);
				while (size != -1) {
					bos.write(data, 0, size);
					size = bis.read(data);
				}
				bis.close();
				bos.flush();// 清空输出缓冲流
				bos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return null;
	}
	//提交小结结果
	@RequestMapping(value="/submitSummary.action")
	public ModelAndView SubmitSummary(HttpServletRequest request,GuchIDdItemID giBean){
		int res = SummaryBizImp.subSumm(giBean);
		//得到登录对象信息
		AdminBean adminBean = (AdminBean) request.getSession().getAttribute("adminBean");
		//得到对应的科室ID
		int depeId =adminBean.getDepaId();
		//维护小结人员表
		int x =SummaryBizImp.addXiao(giBean.getGuChId(), depeId);
		if(x>0) {
			return new ModelAndView("redirect:/doctorSummaryAction/getThisItemStaff.action");
		}
		return null;
	}
	
}
