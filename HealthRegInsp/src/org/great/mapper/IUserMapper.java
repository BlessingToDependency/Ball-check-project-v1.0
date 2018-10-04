package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.SetmealBean;
import org.great.bean.ShoppingCartBean;
import org.great.bean.StaffBean;
import org.great.bean.StaffMealBean;
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
	
	//加入购物车
	public void addShoppingCart(ShoppingCartBean shoppingCartBean);
	
	//查询购物车
	public List<ShoppingCartBean> shoppingCart(@Param("companyId")Integer companyId);
	
	//注册名查重
	public UserBean userRepeat(@Param("company")String company);
	
	//上传文档插入数据库
	public void addStaff(StaffBean staffBean);
	
	//插入员工导检单关系表
	public void addPerguirela(PerguirelaBean perguirelaBean);
	
	//修改员工预约状态
	public void updateState(PerguirelaBean perguirelaBean);
	
	//为员工选择套餐插入数据库
	public void bespeakMeal(StaffMealBean staffMealBean);
	
	//身份证去重
	public StaffBean repeatNum(String idNum);

	//前端修改密码
	public void  updateUserPws(@Param("pwd")String pwd,@Param("company")String company);

	//增加账单
	public void userBill(BillBean billBean);
	
	//查看公司信息
	public  List<UserBean>  selectCompInfo(@Param("company")String company);
	
	//获得用户开单列表（L）
	public List<UserBean> OpenBillUserList();
	
	//编辑公司信息
	public void updateCompInfo(@Param("company")String company);
	
	//前台套餐展示
	public  List<SetmealBean> showSetmeal(@Param("setmealId")String setmealId);
	
	//编辑公司信息
    public void updateCompInfo(UserBean userBean);


}
