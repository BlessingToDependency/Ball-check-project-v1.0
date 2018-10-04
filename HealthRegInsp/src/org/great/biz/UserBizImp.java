
package org.great.biz;

import java.util.List;
import javax.annotation.Resource;

import org.great.bean.BillBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.SetmealBean;
import org.great.bean.ShoppingCartBean;
import org.great.bean.StaffBean;
import org.great.bean.StaffMealBean;
import org.great.bean.UserBean;
import org.great.mapper.IUserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserBizImp implements UserBiz {

	@Resource
	private IUserMapper iUserMapper;
	
	//前台用户登陆
	@Override
	public UserBean userLogin(UserBean userBean) {
		// TODO Auto-generated method stub
		UserBean uBean = iUserMapper.userLogin(userBean);
		return uBean;
	}
	
	//注册
	@Override
	public void userRegister(UserBean userBean) {
		// TODO Auto-generated method stub
		iUserMapper.userRegister(userBean);
	}

	//查重
	@Override
	public UserBean userRepeat(String company) {
		// TODO Auto-generated method stub
		UserBean uBean = iUserMapper.userRepeat(company);
		return uBean;
	}
	//账单记账	
	@Override
	public void userBill(BillBean billBean) {
		// TODO Auto-generated method stub
		iUserMapper.userBill(billBean);
	}

	//前端修改密码
	@Override
	public void updateUserPws(String pwd,String company) {
		// TODO Auto-generated method stub
		iUserMapper.updateUserPws(pwd,company);
	}
   //查看公司信息
	@Override
	public List<UserBean> selectCompInfo(String company) {
		// TODO Auto-generated method stub
		List<UserBean>  compList=iUserMapper.selectCompInfo(company);
		return compList;
	}

	//编辑公司信息
	@Override
	public void updateCompInfo(String company) {
		// TODO Auto-generated method stub
		iUserMapper.updateCompInfo(company);
	}
	
	//前台套餐展示
	public  List<SetmealBean> showSetmeal(String setmealId){
		List<SetmealBean>  setList=iUserMapper.showSetmeal(setmealId);
		return setList;
		}

	//编辑公司信息
	@Override
	public void updateCompInfo(UserBean userBean) {
			// TODO Auto-generated method stub
			iUserMapper.updateCompInfo(userBean);
		}
	
	//上传文档插入数据库
	@Override
	public void addStaff(StaffBean staffBean) {
		// TODO Auto-generated method stub
		iUserMapper.addStaff(staffBean);
	}
	//身份证去重
	@Override
	public StaffBean repeatNum(String idNum) {
		// TODO Auto-generated method stub
		return iUserMapper.repeatNum(idNum);
	}

	//为员工选择套餐插入数据库
	@Override
	public void bespeakMeal(StaffMealBean staffMealBean) {
		// TODO Auto-generated method stub
		iUserMapper.bespeakMeal(staffMealBean);
	}

	//加入购物车
	@Override
	public void addShoppingCart(ShoppingCartBean shoppingCartBean) {
		// TODO Auto-generated method stub
		iUserMapper.addShoppingCart(shoppingCartBean);
	}

	//插入员工导检单关系表
	@Override
	public void addPerguirela(PerguirelaBean perguirelaBean) {
		// TODO Auto-generated method stub
		iUserMapper.addPerguirela(perguirelaBean);
	}

	@Override
	public void updateState(PerguirelaBean perguirelaBean) {
		// TODO Auto-generated method stub
		iUserMapper.updateState(perguirelaBean);
	}

	//查询购物车
	@Override
	public List<ShoppingCartBean> shoppingCart(Integer companyId) {
		// TODO Auto-generated method stub
		return iUserMapper.shoppingCart(companyId);
	}

}
