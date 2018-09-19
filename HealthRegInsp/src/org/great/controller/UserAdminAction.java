package org.great.controller;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.biz.AdminBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 * 用户管理
 */

@Controller
@RequestMapping("/userAdminAction")
public class UserAdminAction {

	ModelAndView mav = new ModelAndView();
	@Resource
	private AdminBiz adminBizImp;//前台用户接口
	private List<UserBean> userList;
	private int pageCountAll=1;//总页数
	
	
	//用户管理列表展示
	@RequestMapping("userAdmin.action")
	public ModelAndView userAdmin(StaffBean sBean,Integer pages) {
		
		System.out.println("11111111111");
		String page = String.valueOf(pages);
		if(page==null ||"null".equals(page)|| "".equals(page)||"0".equals(page)) {
			pages=1;
		}
		int countAll=adminBizImp.userAdminCount(sBean);//当前用户总个数
		if(countAll%10>0||countAll==0) {
			pageCountAll=countAll/10+1;
		}else {
			pageCountAll=countAll/10;
		}
		userList = adminBizImp.userAdmin(sBean,pages);
		System.out.println(userList.size());
		mav.setViewName("BackEnd/file_list");
		mav.addObject("userList", userList);
		mav.addObject("pages", pages);//当前页
		return mav;
	}
}
