package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.search.BatchSheetCon;
import org.great.search.CompanyCon;

/*
 * 团检单位开单Biz接口
 */
public interface IMissInspBiz {
	//显示体检单位列表
	public List<UserBean> companyList(CompanyCon companyCon);
	
	//总的体检单位列表
	public List<UserBean> allCompanyList(CompanyCon companyCon);
	
	//获取对应公司人员列表(分页、模糊)
	public List<StaffBean> staffList(BatchSheetCon batchSheetCon);
		
	//获取对应公司人员列表(总的、模糊)
	public List<StaffBean> allStaffList(BatchSheetCon batchSheetCon);
	
	//获取该公司的团检年份
	public List<String> yearsList(int companyId);
	
	//得到对应公司年份的批次号
	public List<String> batchNum(String partYear,int companyId);

	//得到员工的套餐ID
	public List<String> setMealid(int smid);
	
	 //维护导检单对应套餐
	public int maintain(String guChId,int setmealId);

}
