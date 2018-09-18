package org.great.biz;

import org.great.bean.AdminBean;

public interface AdminBiz {
	//后台登陆
	public AdminBean adminLogin(AdminBean adminBean);
	//后台新增用户（注册）
	public void adminRegister(AdminBean adminBean);
}
