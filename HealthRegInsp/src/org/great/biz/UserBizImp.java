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
	private IUserMapper iUserMapperDao;
	
	//前台用户登陆
	@Override
	public UserBean userLogin(UserBean userBean) {
		// TODO Auto-generated method stub
		UserBean uBean = iUserMapperDao.userLogin(userBean);
		return uBean;
	}
	
	//注册
	@Override
	public void userRegister(UserBean userBean) {
		// TODO Auto-generated method stub
		iUserMapperDao.userRegister(userBean);
	}

	//查重
	@Override
	public UserBean userRepeat(String company) {
		// TODO Auto-generated method stub
		UserBean uBean = iUserMapperDao.userRepeat(company);
		return uBean;
	}
	//账单记账	
	@Override
	public void userBill(BillBean billBean) {
		// TODO Auto-generated method stub
		iUserMapperDao.userBill(billBean);
	}


}
