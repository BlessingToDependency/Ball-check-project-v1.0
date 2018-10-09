package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.bean.BuyNowBean;
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
	
	//重置密码
	public int resetPwd(@Param("companyNick")String companyNick,@Param("industryNum")String industryNum,@Param("passWord")String passWord);

	//前台用户注册
	public void userRegister(UserBean userBean);

	//插入关系表前，查询当前公司、当前年份下，是否有上传过人员
	public List<PerguirelaBean> selectBatchNum(Integer companyId);

	//如果有值，则取出最大批次号
	public Integer maxBatchNum(Integer companyId);

	//批量预约
	public List<StaffBean> batchMeal(@Param("companyId")Integer companyId);
	
	//展示已订购套餐
	public List<BuyNowBean> chooseAlreadyMeal(BuyNowBean buyNowBean);

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

	//插入公司账单表
	public void companyBill(@Param("companyId")Integer companyId,@Param("actCharge")double actCharge,@Param("payState")Integer payState);

	//插入立即购买表tblBuyNow
	public void companyBuyNow(@Param("setmealBean")SetmealBean setmealBean,@Param("companyId")Integer companyId);
	
	//查询出公司账单表；人数;实际收费
	public BillBean numberPeople(@Param("companyId")Integer companyId);

	//每插入一次个人账单表，需要修改公司账单表的数据：人数，实际金额；员工id
	public void updateCompanyBill(BillBean billBean);

	//插入个人账单表
	public void personalBill(@Param(value="staffMealBean")StaffMealBean staffMealBean,@Param(value="companyId")Integer companyId);

	//为员工选择套餐插入数据库
	public void bespeakMeal(StaffMealBean staffMealBean);

	//身份证去重
	public StaffBean repeatNum(@Param("idNum")String idNum,@Param("companyId")Integer companyId);

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
