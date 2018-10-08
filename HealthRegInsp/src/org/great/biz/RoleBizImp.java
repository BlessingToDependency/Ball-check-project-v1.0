package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.RoleBean;
import org.great.mapper.IRoleMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoleBizImp implements IRoleBiz {

	@Resource
	private IRoleMapper iroleMapper;
	//带条件分页查询所有角色
	@Override
	public List<RoleBean> selectAllRole(RoleBean roleBean,RowBounds rowBounds) {
		// TODO Auto-generated method stub
		List<RoleBean> roleList=iroleMapper.selectAllRole(roleBean,rowBounds);
		return roleList;
	}
	
	 //查询角色个数
	@Override
	public List<RoleBean> selectRoleNum(RoleBean roleBean) {
		// TODO Auto-generated method stub
		List<RoleBean> roleList=iroleMapper.selectRoleNum(roleBean);
		return roleList;
	}

	//修改角色名
	@Override
	public void updateRoleNmae(RoleBean roleBean) {
		// TODO Auto-generated method stub
		iroleMapper.updateRoleNmae(roleBean);
		
	}

	//新增角色
	@Override
	public void innerRole(RoleBean roleBean) {
		// TODO Auto-generated method stub
		iroleMapper.innerRole(roleBean);
	}

	//删除角色
	@Override
	public void deleteRole(int roleId) {
		// TODO Auto-generated method stub
		iroleMapper.deleteRole(roleId);
	}

	//查重
	@Override
	public List<RoleBean> checkRole(RoleBean roleBean) {
		// TODO Auto-generated method stub
		List<RoleBean> roleList=iroleMapper.checkRole(roleBean);
		return roleList;
	}

	//查询角色
	@Override
	public List<RoleBean> selectR() {
		// TODO Auto-generated method stub
		List<RoleBean> roleList=iroleMapper.selectR();
		return roleList;
	}

	//查询单个角色
	@Override
	public RoleBean seleRoleInfo(int roleId) {
		// TODO Auto-generated method stub
		RoleBean rol=iroleMapper.seleRoleInfo(roleId);
		return rol;
	}
	
}
