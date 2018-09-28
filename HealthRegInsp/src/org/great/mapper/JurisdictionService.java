package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.JurdisBean;
import org.great.bean.RoleBean;
import org.springframework.stereotype.Repository;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 权限分配管理类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-27 13:23 
*/ 
@Repository
public interface JurisdictionService {

	//查询角色 分页 模糊条件
    public List<RoleBean> sleectRole(@Param(value="roleBean") RoleBean roleBean,@Param("page") Integer page);

    //查询角色总个数
    public Integer selectRoleSum(RoleBean roleBean);
    
    //查询所有的权限
    public List<JurdisBean> selectAllJurd();
    
    //查询所有的父权限
    public List<JurdisBean> selectParentJurd();
    
    //查询所有的子权限
    public List<JurdisBean> selectSonJurd();
    
    //查询单个指定角色信息
    public RoleBean sleectOneRole(@Param("roleId") Integer roleId);
    
    //查询用户拥有的权限
    public List<JurdisBean> selectOneJurd(@Param("roleId") Integer roleId);
    
    //查询指定用户有的父权限
    public List<JurdisBean> selectAllParentJurd(@Param("roleId") Integer roleId);
    
    //查询指定用户有的子权限
    public List<JurdisBean> selectAllSonJurd(@Param("roleId") Integer roleId);
    
    //删除指定角色的所有权限
    public void deleteJurrel(@Param("roleId") Integer roleId);
    
    //增加指定角色的权限
    public void addJurrel(@Param("jurisId") Integer jurisId,@Param("roleId") Integer roleId);
}
