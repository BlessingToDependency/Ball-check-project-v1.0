package org.great.biz;

import java.util.List;

import org.great.bean.UserBean;

/*
 * 团检单位开单Biz接口
 */
public interface IMissInspBiz {
	//显示体检单位列表
	public List<UserBean> CompanyList();
	//下载体检单位人员信息表
	public String DownUnitList(String fileName);

}
