package org.great.biz;

import org.great.bean.UserBean;

/*
 * 前台用户biz总接口
 */
public interface UserBiz {
	//前台用户登陆
	public UserBean userLogin(UserBean userBean);
	
	//前台用户注册
	public void userRegister(UserBean userBean);
	
	//ajax判断注册名是否重复
	public UserBean userRepeat(String company);
	
	//前端修改密码
	public void  updateUserPws(String pwd,String company);
}
