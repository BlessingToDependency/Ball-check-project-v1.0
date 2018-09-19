package org.great.biz;

import java.util.List;

import org.great.bean.AdminBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;

public interface AdminBiz {
	//后台登陆
	public AdminBean adminLogin(AdminBean adminBean);
	//后台新增用户（注册）
	public void adminRegister(AdminBean adminBean);
	//后台用户管理列表展示
	public List<UserBean> userAdmin(StaffBean sBean,Integer pages);
	//后台用户管理列表总数查询
	public Integer userAdminCount(StaffBean sBean);
}
