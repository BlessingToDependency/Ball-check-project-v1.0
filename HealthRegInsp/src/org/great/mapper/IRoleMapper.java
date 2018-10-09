package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.great.bean.RoleBean;
import org.springframework.stereotype.Repository;

/*
 * 角色Mapper
 */
@Repository
public interface IRoleMapper {
	//带条件分页查询所有角色
     public   List<RoleBean>    selectAllRole(RoleBean roleBean,RowBounds rowBounds);
     
     //查询角色个数
     public  List<RoleBean>   selectRoleNum(RoleBean roleBean);
     
     //修改角色名
     public void updateRoleNmae(RoleBean roleBean);
     
     //新增角色
     public void  innerRole(RoleBean roleBean);
     
     //删除角色
     public  void  deleteRole(@Param("roleId")int roleId);
     
     //查重
     public List<RoleBean> checkRole(RoleBean roleBean);
     
     //查询所有角色
     public List<RoleBean>  selectR();
     
     //查询单个角色
     public RoleBean seleRoleInfo(@Param("roleId")int roleId);
     
    
}

