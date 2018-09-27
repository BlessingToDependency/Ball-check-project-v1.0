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
	//查询所有角色
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
	
}
