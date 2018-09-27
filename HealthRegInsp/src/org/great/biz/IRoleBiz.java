package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.great.bean.RoleBean;

/*
 * 角色接口
 */

public interface IRoleBiz {
	//查询所有角色
    public   List<RoleBean>    selectAllRole(RoleBean roleBean,RowBounds rowBounds);
    
    //查询角色个数
    public  List<RoleBean>   selectRoleNum(RoleBean roleBean);
    
    //修改角色名
    public void updateRoleNmae(RoleBean roleBean);
    
    //新增角色
    public void  innerRole(RoleBean roleBean);
    
    //删除角色
    public  void  deleteRole(int roleId);
    
   //查重
    public List<RoleBean> checkRole(RoleBean roleBean);
}
