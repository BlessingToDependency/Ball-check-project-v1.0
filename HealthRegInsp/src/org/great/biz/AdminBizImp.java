package org.great.biz;

import java.util.List;

import org.great.bean.AdminBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.mapper.IAdminMapper;
import org.springframework.stereotype.Service;

/*
 * 后台biz
 */
@Service
public class AdminBizImp implements AdminBiz{
	IAdminMapper iAdminMapper;
	private List<UserBean> userList;
	//登陆
	@Override
	public AdminBean adminLogin(AdminBean adminBean) {
		// TODO Auto-generated method stub
		AdminBean aBean = iAdminMapper.adminLogin(adminBean);
		return aBean;
	}

	
	//注册
	@Override
	public void adminRegister(AdminBean adminBean) {
		// TODO Auto-generated method stub
		iAdminMapper.adminRegister(adminBean);
	}

	//后台用户管理列表展示
	@Override
	public List<UserBean> userAdmin(StaffBean sBean,Integer pages) {
		// TODO Auto-generated method stub
		userList = iAdminMapper.userAdmin(sBean,pages);
		return userList;
	}

	//后台用户管理总数
	@Override
	public Integer userAdminCount(StaffBean sBean) {
		// TODO Auto-generated method stub
		return iAdminMapper.userAdminCount(sBean);
	}
	
	
}
