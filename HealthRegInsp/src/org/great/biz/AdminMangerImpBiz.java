package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.AdminBean;
import org.great.bean.ParamBean;
import org.great.mapper.IAdminMapper;
import org.great.mapper.IParamMapper;
import org.great.search.AdminCon;
import org.springframework.stereotype.Service;
/*
 * 管理员管理实现Biz
 */
@Service
public class AdminMangerImpBiz implements IAdminMangerBiz {
	@Resource
	IParamMapper iParamMapper;
	//管理员列表（L）
	@Override
	public List<AdminBean> getAdminList(AdminCon adminCon) {
		List<AdminBean> adminList = iParamMapper.getFuzzyAdminList(adminCon);
		return adminList;
	}
	
	//所有管理员列表
	@Override
	public List<AdminBean> getAllAdminList(AdminCon adminCon) {
		List<AdminBean> adminList = iParamMapper.getAllFuzzyAdminList(adminCon);
		return adminList;
	}
	
	//获取动态用户状态下拉框
	@Override
	public List<ParamBean> userState() {
		List<ParamBean> stateList = iParamMapper.userStates();
		return stateList;
	}

	//启用禁用管理员
	@Override
	public int endisAdmin(int adid, int val) {
		int res = iParamMapper.endisAdmin(adid, val);
		return res;
	}

	//重置密码
	@Override
	public int resetPwd(int adid, String pwd) {
		int res = iParamMapper.resetPwd(adid, pwd);
		return res;
	}

	//删除管理员
	@Override
	public int delAdmin(int adid) {
		int res = iParamMapper.delAdmin(adid, 5);
		return res;
	}

	//增加管理员
	@Override
	public int addAdmin(AdminBean admin) {
		int res = iParamMapper.addAdmin(admin);
		return res;
	}

	//验证身份证号是否重复
	@Override
	public int checkIdNum(String idNum) {
		int res =0;
		AdminBean admin=iParamMapper.checkIdNum(idNum);
		if(admin!=null) {
			res=admin.getAdminId();
			
		}
		return res;
	}
	//维护关系表
	@Override
	public int addRela(int relaId, int adminId) {
		int res = iParamMapper.rela(relaId, adminId);
		return res;
	}

}
