package org.great.controller;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.JurdisBean;
import org.great.biz.PrivilegeBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 权限管理action 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-26 22:53 
*/ 
@Controller
@RequestMapping("/adminPrivilegeAction")
public class AdminPrivilegeAction {

	@Resource
	private JurdisBean jurdisBean;//权限管理实体类
	
	@Resource
	private PrivilegeBiz privilegeBizImp;//权限管理业务接口
	
	ModelAndView mav = new ModelAndView();
	
	/*
	 * @Description:查询权限信息 
	* @param menu 菜单名称
	* @param page 页数
	* @return（展示方法参数和返回值）
	 */
	@RequestMapping("/selectPrivilege.action")
	public ModelAndView selectPrivilege(Model model ,@RequestParam String menu,Integer page) {
		
		System.out.println(menu);
		if(menu.equals("请输入菜单名称")) {
			menu = "";
			jurdisBean.setMenu("");
		}else {
			jurdisBean.setMenu(menu);
		}
		//查询权限数据总条数
		Integer sum = privilegeBizImp.selectPrivilegeSum(jurdisBean);
		
		model.addAttribute("sum", sum);
		
		Integer p = (int) Math.ceil(Double.valueOf(sum)/10);
		
		model.addAttribute("p", p);
		
		if(page<1) {
			page = 1;
		}else if(page>p){
			page = page - 1;
			
		}
		//查询权限
		List<JurdisBean> list = privilegeBizImp.selectAllPrivilege(jurdisBean, page);
		
		model.addAttribute("list", list);
		if(menu.equals("")) {
			menu = "请输入菜单名称";
		}
		model.addAttribute("menu", menu);
		model.addAttribute("page", page);
		
		mav.setViewName("BackEnd/admin_Privilege");
		return mav;
		
	}
	
	/*
	 * @Description:进入修改模态框 
	* @return返回一个权限信息
	 */
	@RequestMapping("/amendInterface.action")
	@ResponseBody
	public JurdisBean amendInterface(@RequestParam Integer jurisId) {
		
		//调用查询单个权限信息方法
		JurdisBean jurdis = privilegeBizImp.selectOnePrivilege(jurisId);
		
		return jurdis;
		
	}
}
