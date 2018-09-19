package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.AdminBean;

public interface AdminBiz {
	//后台登陆
	public AdminBean adminLogin(AdminBean adminBean);
	
	//后台新增用户（注册）
	public void adminRegister(AdminBean adminBean);
	
	//后台修改密码
	public  void  updateAdminPws(String adminPwd,int adminId);
	
	//后台禁用启用医生
	public void  updateDoctorState(AdminBean adminBean);
	
	//后台逻辑删除医生
	public void  logicDeleteDoc(AdminBean adminBean);
		
	//后台对医生信息进行修改
	public void updateDoctorInfo(AdminBean adminBean);
	
	//查询医生信息
	public  List<AdminBean> slectDoctorInfo(int adminId);
}
