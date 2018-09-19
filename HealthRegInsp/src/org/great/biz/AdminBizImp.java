package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.AdminBean;
import org.great.mapper.IAdminMapper;
import org.springframework.stereotype.Service;

/*
 * 后台biz
 */
@Service
public class AdminBizImp implements AdminBiz{
	@Resource
	IAdminMapper iAdminMapper;
	
	//登陆
	@Override
	public AdminBean adminLogin(AdminBean adminBean) {
		// TODO Auto-generated method stub
		AdminBean aBean = iAdminMapper.adminLogin(adminBean);
		return aBean;
	}

	
	//注册
	@Override
	public void adminRegister(AdminBean adminBean) {
		// TODO Auto-generated method stub
		
		iAdminMapper.adminRegister(adminBean);
	}

    //修改密码
	@Override
	public void updateAdminPws(String adminPwd,int adminId) {
		// TODO Auto-generated method stub
		iAdminMapper.updateAdminPws(adminPwd,adminId);
	}

	//后台禁用启用医生
	@Override
	public void updateDoctorState(AdminBean adminBean) {
		// TODO Auto-generated method stub
		iAdminMapper.updateDoctorState(adminBean);
	}

   //后台逻辑删除医生
	@Override
	public void logicDeleteDoc(AdminBean adminBean) {
		// TODO Auto-generated method stub
		iAdminMapper.logicDeleteDoc(adminBean);
	}

	//后台对医生信息进行修改
	@Override
	public void updateDoctorInfo(AdminBean adminBean) {
		// TODO Auto-generated method stub
		iAdminMapper.updateDoctorInfo(adminBean);
	}

	//查询医生信息
	@Override
	public List<AdminBean> slectDoctorInfo(int adminId) {
		// TODO Auto-generated method stub
		 List<AdminBean> adminList=iAdminMapper.slectDoctorInfo(adminId);
		return adminList;
	}
	
	
}
