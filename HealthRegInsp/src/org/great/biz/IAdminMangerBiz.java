package org.great.biz;

import java.util.List;

import org.great.bean.AdminBean;
import org.great.bean.ParamBean;
import org.great.search.AdminCon;
/*
 * 管理员管理Biz
 */
public interface IAdminMangerBiz {
	//管理员列表
	public List<AdminBean> getAdminList(AdminCon adminCon);
	
	//所有管理员列表
	public List<AdminBean> getAllAdminList(AdminCon adminCon);
	
	//获取动态用户状态下拉框
	public List<ParamBean> userState();
	
	//启用禁用管理员
	public int endisAdmin(int adid,int val);
	
	//重置密码
	public int resetPwd(int adid,String pwd);
	
	//删除管理员
	public int delAdmin(int adid);
	
	//增加管理员
	public int addAdmin(AdminBean admin);
	
	//验证身份证号是否重复
	public int checkIdNum(String idNum);
	
	//维护关系表
	public int addRela(int relaId,int adminId);

}
