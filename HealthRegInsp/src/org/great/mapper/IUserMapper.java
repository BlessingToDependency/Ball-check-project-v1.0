package org.great.mapper;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.bean.UserBean;
import org.springframework.stereotype.Repository;

/*
 * 前台用户mapper接口
 */
@Repository
public interface IUserMapper {
	//前台用户登陆
	public UserBean userLogin(UserBean userBean);
	
	//前台用户注册
	public void userRegister(UserBean userBean);
	
	//注册名查重
	public UserBean userRepeat(@Param("company")String company);
	
	//增加账单
	public void userBill(BillBean billBean);
}
