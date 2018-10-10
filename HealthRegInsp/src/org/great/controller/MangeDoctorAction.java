package org.great.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import org.great.core.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/*
 * 管理医生
 */
@Controller
@RequestMapping("/maDoctorAction")
public class MangeDoctorAction {
	@Resource 
	private AdminBean adminBean;//后台bean
	@Resource 
	private PostBean pb;//职务bean
	@Resource 
	private DeparBean dp;//科室bean
	
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
	@ResponseBody
	@SystemLog(module="医生管理",methods="禁用启用医生")
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
	@ResponseBody
	@SystemLog(module="医生管理",methods="逻辑删除医生")
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
     
		mav.setViewName("BackEnd/edit_docInfo");
		return mav;		
	}
	
	/*
	 * 后台对医生信息进行修改
	 */
	@ResponseBody
	@SystemLog(module="医生管理",methods="修改医生信息")
	@RequestMapping(value="/updateDoctorInfo.action")
	public  ModelAndView updateDoctorInfo(AdminBean aBean) {
		String admin=(String) session.getAttribute("adminId");

		int admindId=Integer.parseInt(admin);
		aBean.setAdminId(admindId);
		
		adminBizImp.updateDoctorInfo(aBean);
		mav.setViewName("BackEnd/edit_docInfo");
		//跳 转到用户展示的方法
		return mav;		
	}
	
	/*
	 * 管理所有医生信息
	 */
	@RequestMapping(value="/selectAllDoctor.action")

	public ModelAndView selectAllDoctor() {
		
		String page=request.getParameter("page");
		
		String adminName=request.getParameter("adminName");
		
		String post=request.getParameter("post");
	
		
		
		pb.setPost(post);		
		String depar=request.getParameter("depa");
		dp.setDepa(depar);
		
		adminBean.setPostBean(pb);
		adminBean.setAdminName(adminName);
		adminBean.setDeparBean(dp);
		
		 int pageNo=-1;
			if(null==page||"".equals(page)) {
				pageNo =1;
				
			}else {
				pageNo = Integer.parseInt(page);
				
			}
		
		int start = 5*pageNo-5; 
		int pagesize =5;
		RowBounds rowBounds = new RowBounds(start,pagesize);

		List<AdminBean> adLis=adminBizImp.selectAllDoctor(adminBean, rowBounds);
		
		
		//session.setAttribute("docList", adLis);
		
		List<AdminBean> adLisN=adminBizImp.selectAllDoctorN(adminBean);
		
		int paN=adLisN.size();
		
		
		int paNum=0;
		mav.addObject("page", pageNo);
		if(paN%5==0) {
			paNum=paN/5;
		}
		if(paN%5!=0) {
			paNum=paN/5+1;
	}
		mav.addObject("docList", adLis);
		mav.addObject("paNum", paNum);
		mav.addObject("adminName", adminBean.getAdminName());
		mav.addObject("post",adminBean.getPostBean().getPost());
		mav.addObject("depa",adminBean.getDeparBean().getDepa());
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
    @ResponseBody
	@SystemLog(module="医生管理",methods="新增医生")
	public  ModelAndView AddDoctor(MultipartFile fileact,HttpServletRequest request,AdminBean aBean) {
    
		String file = fileact.getOriginalFilename();
		System.out.println("获取到的文件名:" + file);
		try {
			String root = request.getServletContext().getRealPath("/upload"); // 设置文件上传的路径
			System.out.println(root);
			fileact.transferTo(new File(root +"/"+ file));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	    aBean.setStateId(3);
		aBean.setLogicId(6);
		aBean.setRoleId(3);
		aBean.setHead(file);
		String ph=(String) session.getAttribute("msg1");
		String idn=(String) session.getAttribute("msg2");
		if(ph.equals("可用手机号")&&idn.equals("可用身份证")) {
		adminBizImp.adminRegister(aBean);
		mav.setViewName("BackEnd/add_doctor");
		}else {
			mav.setViewName("BackEnd/add_doctor");
		}
		return mav;		
	}
	
    /*
     * 手机号查重
     */
    @RequestMapping(value="/checkPhone.action")
    public @ResponseBody void checkPhone(AdminBean aBean) throws Exception{
    	 String phone=request.getParameter("phone");
    	 Long ph= Long.parseLong(phone);
    	  aBean.setPhone(ph);
    	  List<AdminBean> adList=adminBizImp.cheackDoctor(aBean);
    	  
    	  
    		PrintWriter out = response.getWriter();
    		String msg;
    		if(adList.size()>0||ph==null||"".equals(ph)) {
    			msg="不可用手机号";
    			
    		}else {
    			msg="可用手机号";
    		}
    		session.setAttribute("msg1", msg);
    		Gson gson1 = new Gson();
    		String str1 = gson1.toJson(msg);
    		out.print(str1);
    		out.close();
    	
    }
    
    /*
     * 身份证验证
     */
    @RequestMapping(value="/checkidNum.action")
    public @ResponseBody void checkidNum(AdminBean aBean) throws Exception{
    	 String idu=request.getParameter("idNum");
    	 System.out.println("idu");
    	 aBean.setIdNum(idu);
    	 
    	 List<AdminBean> adList=adminBizImp.cheackDoctor(aBean);
   	  
  	   
 		PrintWriter out = response.getWriter();
 		String msg;
 		if(adList.size()>0||idu==null||"".equals(idu)) {
 			msg="不可用身份证";
 			
 		}else {
 			msg="可用身份证";
 		}
 		session.setAttribute("msg2", msg);
 		Gson gson1 = new Gson();
 		String str1 = gson1.toJson(msg);
 		out.print(str1);
 		out.close();
    	
    	
    }
    
    /*
     * 更改角色
     */
    @RequestMapping(value="/updateRole.action")
    @ResponseBody
	@SystemLog(module="医生管理",methods="更改医生角色")
    public ModelAndView updateRole() {
    	String admin=(String) session.getAttribute("uadminId");
    	int adminId=Integer.parseInt(admin);
    	String ro=request.getParameter("roleId");
    	int roleId=Integer.parseInt(ro);
    	
    	adminBizImp.updateRole(adminId, roleId);
    	
		return mav;
    }
 
    

}
