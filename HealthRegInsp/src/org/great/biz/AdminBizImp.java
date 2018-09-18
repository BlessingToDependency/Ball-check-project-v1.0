package org.great.biz;

import org.great.bean.AdminBean;
import org.great.mapper.IAdminMapper;
import org.springframework.stereotype.Service;

/*
 * 后台biz
 */
@Service
public class AdminBizImp implements AdminBiz{
	IAdminMapper iAdminMapper;
	
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
	
	
}
