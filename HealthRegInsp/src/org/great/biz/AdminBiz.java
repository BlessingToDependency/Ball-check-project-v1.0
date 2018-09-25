package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.AdminBean;
import org.great.bean.LitemBean;
import org.great.bean.StaffBean;
import org.great.bean.TermBean;
import org.great.bean.UserBean;

public interface AdminBiz {
	//后台登陆
	public AdminBean adminLogin(AdminBean adminBean);
	
	//后台新增用户（注册）
	public void adminRegister(AdminBean adminBean);

	//后台用户管理列表展示
	public List<StaffBean> userAdmin(String staffName,Long phone,String statTime,String stopTime,String partYear,Integer pages);
	//后台用户管理列表总数查询
	public Integer userAdminCount(String staffName,Long phone,String statTime,String stopTime,String partYear);
	
	//根据用户id查找对应信息
	public StaffBean userInfo(String staffId);
	
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
	
	//增加项目
	public void addItem(LitemBean litemBean);

	//查询项目(通用 模糊分页  排序)
	public List<LitemBean> selectLitem(@Param("litemBean")LitemBean litemBean,@Param("peakPrice")String peakPrice,@Param("bottomPrice")String bottomPrice,
				@Param("rank")String rank,@Param("page")Integer page);
		
	//查询项目总数(通用)
	public Integer selectLitemSum(@Param("litemBean")LitemBean litemBean,@Param("peakPrice")String peakPrice,@Param("bottomPrice")String bottomPrice);

	//查询指定项目的细项
	public List<TermBean> selectTerm(LitemBean litemBean);

}
