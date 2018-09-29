package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.JurdisBean;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 权限管理业务抽象类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-26 23:37 
*/ 
public interface PrivilegeBiz {

	//查询权限(分页  模糊 条件)
	public List<JurdisBean> selectAllPrivilege(@Param(value="jurdisBean") JurdisBean jurdisBean,
			@Param("page") Integer page);
	
	//查询权限总条数
	public Integer selectPrivilegeSum(JurdisBean jurdisBean);
	
	//查询单个权限信息
	public JurdisBean selectOnePrivilege(@Param("jurisId") Integer jurisId);
}
