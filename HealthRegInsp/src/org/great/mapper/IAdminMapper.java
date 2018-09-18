package org.great.mapper;

import org.great.bean.AdminBean;
import org.springframework.stereotype.Repository;
/*
 * 后台Mapper
 */
@Repository
public interface IAdminMapper {
	//后台登陆
	public AdminBean adminLogin(AdminBean adminBean);
	//后台新增用户（注册）
	public void adminRegister(AdminBean adminBean);
}
