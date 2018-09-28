package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.great.bean.JurdisBean;
import org.great.mapper.PrivilegeServic;
import org.springframework.stereotype.Service;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 权限管理业务类实现类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-26 23:39 
*/ 
@Service
public class PrivilegeBizImp implements PrivilegeBiz{

	@Resource
	private PrivilegeServic privilegeServic;//权限管理接口
	
	//查询权限(分页  模糊 条件)
	@Override
	public List<JurdisBean> selectAllPrivilege(JurdisBean jurdisBean, Integer page) {
		// TODO Auto-generated method stub
		List<JurdisBean> list = privilegeServic.selectAllPrivilege(jurdisBean, page);
		return list;
	}

	//查询权限总条数
	@Override
	public Integer selectPrivilegeSum(JurdisBean jurdisBean) {
		// TODO Auto-generated method stub
		Integer sum = privilegeServic.selectPrivilegeSum(jurdisBean);
		return sum;
	}

	//查询单个权限信息
	@Override
	public JurdisBean selectOnePrivilege(Integer jurisId) {
		// TODO Auto-generated method stub
		JurdisBean jb = privilegeServic.selectOnePrivilege(jurisId);
		return jb;
	}

}
