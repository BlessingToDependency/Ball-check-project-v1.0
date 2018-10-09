package org.great.biz;

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

/*
 * 前台用户biz总接口
 */
public interface UserBiz {
	//前台用户登陆
	public UserBean userLogin(UserBean userBean);
	
	//重置密码
	public int resetPwd(String companyNick,String industryNum,String passWord);
	
	//前台用户注册
	public void userRegister(UserBean userBean);
	
	//上传文档插入数据库
	public void addStaff(StaffBean staffBean);
	
	//批量预约
	public List<StaffBean> batchMeal(Integer companyId);
	
	//展示已订购套餐
	public List<BuyNowBean> chooseAlreadyMeal(BuyNowBean buyNowBean);
	
	//插入公司账单表
	public void companyBill(Integer companyId,double actCharge,Integer payState);
	
	//插入立即购买表tblBuyNow
	public void companyBuyNow(SetmealBean setmealBean,Integer companyId);
	
	//查询出公司账单表；人数;实际收费
	public BillBean numberPeople(Integer CompanyId);
	
	//每插入一次个人账单表，需要修改公司账单表的数据：人数，实际金额；员工id
	public void updateCompanyBill(BillBean billBean);
	
	//插入个人账单表
	public void personalBill(StaffMealBean staffMealBean,Integer companyId);
	
	//插入关系表前，查询当前公司、当前年份下，是否有上传过人员
	public List<PerguirelaBean> selectBatchNum(Integer companyId);
	
	//如果有值，则取出最大批次号
	public Integer maxBatchNum(Integer companyId);
	
	//插入员工导检单关系表
	public void addPerguirela(PerguirelaBean perguirelaBean);
	
	//修改员工预约状态
	public void updateState(PerguirelaBean perguirelaBean);
	
	//为员工选择套餐插入数据库
	public void bespeakMeal(StaffMealBean staffMealBean);
	
	//加入购物车
	public void addShoppingCart(ShoppingCartBean shoppingCartBean);
	
	//查询购物车
	public List<ShoppingCartBean> shoppingCart(Integer companyId);
	
	//身份证去重
	public StaffBean repeatNum(String idNum,Integer companyId);
	
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
	
	//编辑公司信息
   public void updateCompInfo(UserBean userBean);

}
