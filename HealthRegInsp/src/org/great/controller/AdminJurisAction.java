package org.great.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.bean.JurdisBean;
import org.great.bean.RoleBean;
import org.great.bean.TermBean;
import org.great.biz.JurisdictionBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 权限分配Action类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-27 11:12 
*/ 
@Controller
@RequestMapping("/adminJurisAction")
public class AdminJurisAction {

	@Resource
	private JurisdictionBiz jurisdictionBizImp;//权限分配业务抽象类
	
	@Resource
	private RoleBean roleBean;//角色实体类
	
	ModelAndView mav = new ModelAndView();
	
	/*
	 * @Description:查询角色(分页模糊查询) 
	* @return（展示方法参数和返回值）
	 */
	@RequestMapping("/showRole.action")
	public ModelAndView showRole(Model model,@RequestParam String role,@RequestParam Integer page) {
		
		if(role.equals("请输入角色名")) {
			role = "";
			roleBean.setRole("");
		}else {
			roleBean.setRole(role);
		}
		
		//调用插叙细项总数
		Integer sum = jurisdictionBizImp.selectRoleSum(roleBean);
		
		model.addAttribute("sum", sum);
		
		Integer p = (int) Math.ceil(Double.valueOf(sum)/10);
		
		model.addAttribute("p", p);
		
		if(page<1) {
			page = 1;
		}else if(page>p){
			page = page - 1;
			
		}
		//调用模糊条件分页查询细项方法
		List<RoleBean> list = jurisdictionBizImp.sleectRole(roleBean, page);
		
		model.addAttribute("list", list);
		
		if(role.equals("")) {
			role = "请输入角色名";
		}
		
		model.addAttribute("role", role);
		model.addAttribute("page", page);
		mav.setViewName("BackEnd/admin_Juris");
		
		return mav;	
		
	}
	
	/*
	 * @Description:获取对应角色的权限信息 
	* @return（展示方法参数和返回值）
	 */
	@RequestMapping("/allotJuris.action")
	@ResponseBody
	public Map<String,Object> allotJuris(RoleBean roleBean) {
		
		Map<String,Object> map = new HashMap<String,Object>();

//		System.out.println("角色ID:"+roleBean.getRoleId());
		//查询当前角色的信息
		RoleBean rb = jurisdictionBizImp.sleectOneRole(roleBean.getRoleId());
//		System.out.println(rb.toString());
		//查询所有的父权限信息
		List<JurdisBean> jurdList = jurisdictionBizImp.selectParentJurd();
//		System.out.println("父权限："+jurdList.toString());
		//查询所有的权限信息
		List<JurdisBean> sonList = jurisdictionBizImp.selectAllJurd();
//		System.out.println("所有权限："+sonList.toString());
		//调用查询当前角色拥有的父权限
		List<JurdisBean> jbList = jurisdictionBizImp.selectAllParentJurd(roleBean.getRoleId());
//		System.out.println("拥有的父权限："+jbList.toString());
		//调用查询当前角色拥有的子权限
		List<JurdisBean> jbSonList = jurisdictionBizImp.selectAllSonJurd(roleBean.getRoleId());
//		System.out.println("拥有的子权限："+jbSonList.toString());
		map.put("rb", rb);
		map.put("jurdList", jurdList);//所有父权限
		map.put("jbList", jbList);//单前角色的父权限
		map.put("sonList", sonList);//所有权限
		map.put("jbSonList", jbSonList);//单前角色的子权限
		return map;	
	}
	
	/*
	 * @Description:向用户授权
	* @return（展示方法参数和返回值）
	 */
	@RequestMapping("/amendJuris.action")
	@ResponseBody
	public Map<String,Object> amendJuris(RoleBean roleBean, Integer[] superList,Integer[] childList) {
		Map<String,Object> map = new HashMap<String,Object>();
//		System.out.println(roleBean.getRoleId());
		//调用删除角色所有权限
		jurisdictionBizImp.deleteJurrel(roleBean.getRoleId());
		
//		System.out.println(superList);
//		System.out.println(childList);
		
		//子权限
		for(int i =0;i<superList.length;i++) {
//			System.out.println(superList[i]);
			//调用增加角色权限方法
			jurisdictionBizImp.addJurrel(superList[i], roleBean.getRoleId());
		}
		//父权限
		for(int i =0;i<childList.length;i++) {
//			System.out.println(childList[i]);
			jurisdictionBizImp.addJurrel(childList[i], roleBean.getRoleId());
		}
		map.put("win", "设置成功");
		return map;
		
	}
}
