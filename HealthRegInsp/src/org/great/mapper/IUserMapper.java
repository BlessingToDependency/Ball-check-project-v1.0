package org.great.mapper;

import java.util.List;

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
	

	//前端修改密码
	public void  updateUserPws(@Param("pwd")String pwd,@Param("company")String company);

	//增加账单
	public void userBill(BillBean billBean);
	
	//查看公司信息
	public  List<UserBean>  selectCompInfo(@Param("company")String company);
	
	//获得用户开单列表（L）
	public List<UserBean> OpenBillUserList();


}
