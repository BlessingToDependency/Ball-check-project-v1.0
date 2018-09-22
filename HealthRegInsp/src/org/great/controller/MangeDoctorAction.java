package org.great.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.AdminBean;
import org.great.bean.DeparBean;
import org.great.bean.PostBean;
import org.great.biz.AdminBiz;
import org.great.biz.IdeparBiz;
import org.great.biz.PostBiz;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/*
 * 管理医生
 */
@Controller
@RequestMapping("/maDoctorAction")
public class MangeDoctorAction {
	@Resource 
	private AdminBean adminBean;//后台bean
	
	@Resource
	private AdminBiz adminBizImp;//前台用户接口
	@Resource
	private PostBiz postBizImp;//职位接口
	@Resource
	private IdeparBiz deparImp;//科室接口
	
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
	 * 修改后台用户密码
	 */
	@RequestMapping(value="updateAdminPws.action")
	public  ModelAndView updateAdminPws(String adminPwd,int adminId) {
		
		adminBizImp.updateAdminPws(adminPwd,adminId);
		
		//跳转到用户展示的方法
		return mav;
		
	}
	
	/*
	 * 修改后台医生状态（禁用启用）
	 */
	@RequestMapping(value="updateDoctorState.action")
	public ModelAndView updateDoctorState(AdminBean aBean) {
		int stateId=Integer.parseInt(request.getParameter("stateId"));
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		
		aBean.setStateId(stateId);
		aBean.setAdminId(adminId);
		adminBizImp.updateDoctorState(aBean);
		
		//跳转到用户展示的方法
		return new ModelAndView("redirect:/maDoctorAction/selectAllDoctor.action");
	}
	
	/*
	 * 逻辑删除医生
	 */
	@RequestMapping(value="/logicDeleteDoc.action")
	public ModelAndView logicDeleteDoc(AdminBean aBean) {
		int logicId=Integer.parseInt(request.getParameter("logicId"));
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		
		aBean.setLogicId(logicId);
		aBean.setAdminId(adminId);
		adminBizImp.logicDeleteDoc(aBean);
		//跳 转到用户展示的方法
		return new ModelAndView("redirect:/maDoctorAction/selectAllDoctor.action");

	}
	
	/*
	 * 跳转到修改信息界面
	 */
	@RequestMapping(value="/toUpdateDoctorInfo.action")
	public  ModelAndView toUpdateDoctorInfo() {
        List<PostBean>   postList=postBizImp.selectAllPost();
        session.setAttribute("postList", postList);
		
        List<DeparBean> deparList=deparImp.selectAllDepar();
        session.setAttribute("deparList", deparList);
        
        String adm=request.getParameter("adminId");
        session.setAttribute("adminId", adm);
        
        int adminId=Integer.parseInt(adm);
        List<AdminBean>  adList=adminBizImp.slectDoctorInfo(adminId);
        session.setAttribute("adList", adList);
        
		//跳 转到用户展示的方法
		mav.setViewName("BackEnd/edit_docInfo");
		return mav;		
	}
	
	/*
	 * 后台对医生信息进行修改
	 */
	@RequestMapping(value="/updateDoctorInfo.action")
	public  ModelAndView updateDoctorInfo(AdminBean aBean) {
		String admin=(String) session.getAttribute("adminId");

		int admindId=Integer.parseInt(admin);
		aBean.setAdminId(admindId);
		
		adminBizImp.updateDoctorInfo(aBean);
		
		//跳 转到用户展示的方法
		return new ModelAndView("redirect:/maDoctorAction/selectAllDoctor.action");		
	}
	
	/*
	 * 管理所有医生信息
	 */
	@RequestMapping(value="/selectAllDoctor.action")
	public ModelAndView selectAllDoctor(AdminBean aBean) {
		
		String page=request.getParameter("page");
		String adminName=request.getParameter("adminName");
		aBean.setAdminName(adminName);
		 int pageNo=-1;
			if(null==page) {
				pageNo =1;
				
			}else {
				pageNo = Integer.parseInt(page);
				
			}
		
		int start = 3*pageNo-3; 
		int pagesize =3;
		RowBounds rowBounds = new RowBounds(start,pagesize);
		
		List<AdminBean> adLis=adminBizImp.selectAllDoctor(aBean, rowBounds);
		
		
		session.setAttribute("docList", adLis);
		
		List<AdminBean> adLisN=adminBizImp.selectAllDoctorN(aBean);
		int paN=adLisN.size();
		int paNum=0;
		mav.addObject("page", pageNo);
		if(paN%3==0) {
			paNum=paN/3;
		}
		if(paN%3!=0) {
			paNum=paN/3+1;
	}
		mav.addObject("paNum", paNum);
		mav.addObject("adminName", aBean.getAdminName());
		mav.setViewName("BackEnd/mange_doctor");
		return mav;
				
	}
	
	/*
	 * 跳转到新增医生界面
	 */
	@RequestMapping(value="/toAddDoctor.action")
	public  ModelAndView toAddDoctor() {
		 List<PostBean>   postList=postBizImp.selectAllPost();
	        session.setAttribute("postList", postList);
			
	        List<DeparBean> deparList=deparImp.selectAllDepar();
	        session.setAttribute("deparList", deparList);
	        
		mav.setViewName("BackEnd/add_doctor");
		return mav;		
	}
	
	/*
	 * 新增医生
	 */
    @RequestMapping(value="/AddDoctor.action",method=RequestMethod.POST)
	public  ModelAndView AddDoctor(MultipartFile fileact,HttpServletRequest request,AdminBean aBean) {
    	System.out.println("zzzzzzzzz="+aBean.getAdminName());
		String file = fileact.getOriginalFilename();
		System.out.println("获取到的文件名:" + file);
		try {
			String root = request.getServletContext().getRealPath("/upLoad"); // 设置文件上传的路径
			System.out.println(root);
			fileact.transferTo(new File(root +"/"+ file));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	     aBean.setStateId(3);
		aBean.setLogicId(6);
		aBean.setRoleId(1);
		aBean.setHead(file);
		adminBizImp.adminRegister(aBean);
		mav.setViewName("BackEnd/add_doctor");
		return mav;		
	}
	

}
