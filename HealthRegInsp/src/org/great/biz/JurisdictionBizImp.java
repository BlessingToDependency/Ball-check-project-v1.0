package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.great.bean.JurdisBean;
import org.great.bean.RoleBean;
import org.great.mapper.JurisdictionService;
import org.springframework.stereotype.Service;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 权限分配业务实现类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-27 13:49 
*/ 
@Service
public class JurisdictionBizImp implements JurisdictionBiz{

	@Resource
	private JurisdictionService jurisdictionService;//权限分配抽象类
	
	//查询角色 分页 模糊条件
	@Override
	public List<RoleBean> sleectRole(RoleBean roleBean, Integer page) {
		// TODO Auto-generated method stub
		List<RoleBean> list = jurisdictionService.sleectRole(roleBean, page);
		return list;
	}

	//查询角色总个数
	@Override
	public Integer selectRoleSum(RoleBean roleBean) {
		// TODO Auto-generated method stub
		Integer sum = jurisdictionService.selectRoleSum(roleBean);
		return sum;
	}

	//查询所有的权限
	@Override
	public List<JurdisBean> selectAllJurd() {
		// TODO Auto-generated method stub
		List<JurdisBean> list = jurisdictionService.selectAllJurd();
		return list;
	}

	//查询单个指定角色信息
	@Override
	public RoleBean sleectOneRole(Integer roleId) {
		// TODO Auto-generated method stub
		RoleBean rb = jurisdictionService.sleectOneRole(roleId);
		return rb;
	}

	//查询用户拥有的权限
	@Override
	public List<JurdisBean> selectOneJurd(Integer roleId) {
		// TODO Auto-generated method stub
		List<JurdisBean> list = jurisdictionService.selectOneJurd(roleId);
		return list;
	}

	//查询所有的父权限
	@Override
	public List<JurdisBean> selectParentJurd() {
		// TODO Auto-generated method stub
		List<JurdisBean> list = jurisdictionService.selectParentJurd();
		return list;
	}

	//查询所有的子权限
	@Override
	public List<JurdisBean> selectSonJurd() {
		// TODO Auto-generated method stub
		List<JurdisBean> list = jurisdictionService.selectSonJurd();
		return list;
	}

	//查询指定用户有的父权限
	@Override
	public List<JurdisBean> selectAllParentJurd(Integer roleId) {
		// TODO Auto-generated method stub
		List<JurdisBean> list = jurisdictionService.selectAllParentJurd(roleId);
		return list;
	}

	//查询指定用户有的子权限
	@Override
	public List<JurdisBean> selectAllSonJurd(Integer roleId) {
		// TODO Auto-generated method stub
		List<JurdisBean> list = jurisdictionService.selectAllSonJurd(roleId);
		return list;
	}

	 //删除指定角色的所有权限
	@Override
	public void deleteJurrel(Integer roleId) {
		// TODO Auto-generated method stub
		jurisdictionService.deleteJurrel(roleId);
	}

	//增加指定角色的权限
	@Override
	public void addJurrel(Integer jurisId, Integer roleId) {
		// TODO Auto-generated method stub
		jurisdictionService.addJurrel(jurisId, roleId);
		
	}

}
