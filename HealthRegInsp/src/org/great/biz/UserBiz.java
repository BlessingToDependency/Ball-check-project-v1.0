package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.bean.SetmealBean;
import org.great.bean.StaffBean;
import org.great.bean.StaffMealBean;
import org.great.bean.UserBean;

/*
 * 前台用户biz总接口
 */
public interface UserBiz {
	//前台用户登陆
	public UserBean userLogin(UserBean userBean);
	
	//前台用户注册
	public void userRegister(UserBean userBean);
	
	//上传文档插入数据库
	public void addStaff(StaffBean staffBean);
	
	//为员工选择套餐插入数据库
	public void bespeakMeal(StaffMealBean staffMealBean);
	
	//身份证去重
	public StaffBean repeatNum(String idNum);
	
	//ajax判断注册名是否重复
	public UserBean userRepeat(String company);
	
	//前端修改密码
	public void  updateUserPws(String pwd,String company);

	//增加账单
	public void userBill(BillBean billBean);
	
	//查看公司信息
	public  List<UserBean>  selectCompInfo(String company);
	
	//编辑公司信息
	public void updateCompInfo(String company);
	
	//前台套餐展示
	public  List<SetmealBean> showSetmeal(String setmealId);

}
