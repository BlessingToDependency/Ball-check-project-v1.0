package org.great.controller;
/*
 * 前台用户登陆
 */

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.great.bean.UserBean;
import org.great.biz.UserBiz;
import org.great.tools.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
@Scope("prototype")
@RequestMapping("userLoginAction")
public class UserLoginAction {
	@Resource 
	private UserBean userBean;//前台用户bean
	@Resource
	private UserBiz userBizImp;//前台用户接口

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
	 * 跳转到登陆页面
	 */
	@RequestMapping("jumpLogin.action")
	public ModelAndView jumpLogin() {
		return new ModelAndView("redirect:/user_login.jsp");
	}

	/*
	 * 用户登陆
	 */

	@RequestMapping("userLogin.action")
	public ModelAndView userLogin(HttpServletRequest request,UserBean uBean,String login_username,String login_password,String imageCode) {
		uBean.setCompany(login_username);
		uBean.setPwd(login_password);
		System.out.println("imageCode="+imageCode);
		String code = (String) session.getAttribute("keyCode");

		if(imageCode.equalsIgnoreCase(code)) {
			userBean = userBizImp.userLogin(uBean);
			//登陆成功则进入if
			if(null != userBean) {
				session.setAttribute("userBean", userBean);
				return new ModelAndView("redirect:/userMainAction/showSetmeal.action");
			}else {
				request.setAttribute("login","登陆失败，账号密码不匹配！");
				//			ModelAndView mav = new ModelAndView("redirect:/user_login.jsp");
				//			mav.addObject("login","登陆失败，账号密码不匹配！");
				mav.setViewName("user_login");
			}
		}else {
			request.setAttribute("login","登陆失败，验证码不正确！");
			mav.setViewName("user_login");
		}
		return mav;
	}
	/*
	 * 验证码
	 */
	@RequestMapping("imageCode.action")
	public void imageCode(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("来个验证码");

		Map<String, BufferedImage> imageb= ImageUtil.createImage();
		//得到验证码
		String code = imageb.keySet().iterator().next();
		//得到图片
		BufferedImage  image = imageb.get(code);

		//验证码存在session
		request.getSession().setAttribute("keyCode", code);

		//输出图片
		ServletOutputStream out = response.getOutputStream();

		//第一个参数是图片，第二个是扩展名，第三个输出方式
		ImageIO.write(image, "jpg", out);
	}

	/*
	 * 重置密码
	 * 
	 */
	@RequestMapping("resetPwd.action")
	public ModelAndView resetPwd(HttpServletRequest request,String companyNick,String industryNum,String passWord) {
		System.out.println(companyNick+industryNum+passWord);
		int i = userBizImp.resetPwd(companyNick,industryNum,passWord);
		if(i>0) {
			request.setAttribute("msg", "重置成功，请登录！");
			return new ModelAndView("redirect:/user_login.jsp");
		}else {
			request.setAttribute("msg", "重置失败，输入有误！");
			return new ModelAndView("redirect:/user_login.jsp");
		}
	}

	/*
	 * 用户注册
	 */
	@RequestMapping("userRegister.action")
	public ModelAndView userRegister(UserBean uBean) {

		uBean.setHead("images/user.png");//设置默认头像
		userBizImp.userRegister(uBean);
		mav.setViewName("user_login");
		return mav;
	}

	/*
	 * AJAX判断公司注册名是否重复:传入公司名
	 */
	@RequestMapping("userRepeat.action")
	@ResponseBody
	public void userRepeat(String company)throws Exception{
		System.out.println(company);
		String str;
		UserBean ub = userBizImp.userRepeat(company);
		PrintWriter out = response.getWriter();

		//1=存在；2=不存在
		if(null != ub) {
			str ="1";
		}else {
			str ="2";
		}
		out.print(str);
		out.close();
	}

	/*
	 * 修改公司登陆密码
	 */

	@RequestMapping(value="/updateUserPws.action")
	public  ModelAndView updateAdminPws(String pwd) {		
		String msg=(String) session.getAttribute("msg");
		UserBean uBean=(UserBean) session.getAttribute("userBean");
		String company=uBean.getCompany();

		if(msg.equals("密码正确")) {
			userBizImp.updateUserPws(pwd,company);
			mav.setViewName("FrontEnd/user_index");
		}
		else {
			mav.setViewName("FrontEnd/update_CompPws");
		}
		return mav;

	}

	/*
	 * 查询公司信息
	 */
	@RequestMapping(value="/selectCompInfo.action")
	public ModelAndView  selectCompInfo() {

		UserBean userBean=(UserBean) session.getAttribute("userBean");
		String componey=userBean.getCompany();
		//String componey="公司";
		List<UserBean> compList=userBizImp.selectCompInfo(componey);
		session.setAttribute("compList", compList);
		mav.setViewName("FrontEnd/company_Info");
		return mav;
	}


	/*
	 * 跳转到修改密码界面
	 */
	@RequestMapping(value="/toUpPws.action")
	public ModelAndView toUpPws() {

		mav.setViewName("FrontEnd/update_CompPws");
		return mav;

	}

	/*
	 * AJAX判断修改密码时，原密码是否正确
	 */
	@RequestMapping(value="/validateCompPws.action")
	public @ResponseBody void validateCompPws(UserBean uBean)throws Exception{
		PrintWriter out = response.getWriter();
		UserBean uBea=(UserBean) session.getAttribute("userBean");
		String company=uBea.getCompany();
		uBean.setCompany(company);
		userBean = userBizImp.userLogin(uBean);
		String msg;
		if(userBean!=null) {
			msg="密码正确";

		}else {
			msg="密码错误";
		}
		session.setAttribute("msg", msg);
		Gson gson1 = new Gson();
		String str1 = gson1.toJson(msg);
		out.print(str1);
		out.close();

	}


	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public UserBiz getUserBizImp() {
		return userBizImp;
	}

	public void setUserBizImp(UserBiz userBizImp) {
		this.userBizImp = userBizImp;
	}

}


