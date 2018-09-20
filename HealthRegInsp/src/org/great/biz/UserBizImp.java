
package org.great.biz;

import java.util.List;
import javax.annotation.Resource;

import org.great.bean.BillBean;
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


}
