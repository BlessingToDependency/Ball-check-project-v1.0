package org.great.biz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.great.bean.UserBean;
import org.great.mapper.IUserMapper;
import org.springframework.stereotype.Service;

/*
 * 团检单位开单Biz实现类
 */
@Service
public class MissInspBizImp implements IMissInspBiz{
	@Resource
	private IUserMapper iUserMapper;
	//得到开单单位信息列表
	@Override
	public List<UserBean> CompanyList() {
		List<UserBean> userList = new ArrayList<UserBean>();
		userList=iUserMapper.OpenBillUserList();
		return userList;
	}
	//下载体检单位人员信息表
	@Override
	public String DownUnitList(String fileName) {
		// TODO Auto-generated method stub
		
		//根据文件名下载文件
		
		return null;
	}

}
