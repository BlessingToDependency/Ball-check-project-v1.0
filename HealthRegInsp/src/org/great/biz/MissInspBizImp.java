package org.great.biz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.mapper.IGroupInspMapper;
import org.great.mapper.IUserMapper;
import org.great.search.BatchSheetCon;
import org.great.search.CompanyCon;
import org.springframework.stereotype.Service;

/*
 * 团检单位开单Biz实现类
 */
@Service
public class MissInspBizImp implements IMissInspBiz{
	@Resource
	private IGroupInspMapper iGroupInspMapper;
	//得到开单单位信息列表
	@Override
	public List<UserBean> companyList(CompanyCon companyCon) {
		List<UserBean> userList = new ArrayList<UserBean>();
		userList=iGroupInspMapper.unitList(companyCon);
		return userList;
	}
	//得到所有开单单位信息列表
	@Override
	public List<UserBean> allCompanyList(CompanyCon companyCon) {
		List<UserBean> userList = new ArrayList<UserBean>();
		userList=iGroupInspMapper.allUnitList(companyCon);
		return userList;
	}
	//获取对应公司人员列表(分页、模糊)
	@Override
	public List<StaffBean> staffList(BatchSheetCon batchSheetCon) {
		List<StaffBean> staffList = iGroupInspMapper.staffList(batchSheetCon);
		return staffList;
	}
	//获取对应公司人员列表(总的、模糊)
	@Override
	public List<StaffBean> allStaffList(BatchSheetCon batchSheetCon) {
		List<StaffBean> staffList = iGroupInspMapper.allStaffList(batchSheetCon);
		return staffList;
	}
	//获取该公司的团检年份
	@Override
	public List<String> yearsList(int companyId) {
		List<String> years = iGroupInspMapper.years(companyId);
		return years;
	}
	//得到对应公司年份的批次号
	@Override
	public List<String> batchNum(String partYear, int companyId) {
		List<String> batchNum = iGroupInspMapper.batchNum(partYear, companyId);
		return batchNum;
	}
	//得到员工的套餐ID
	@Override
	public List<String> setMealid(int smid) {
		List<String> list = iGroupInspMapper.setMealid(smid);
		return list;
	}
	//维护导检单对应套餐
	@Override
	public int maintain(String guChId, int setmealId) {
		int res =iGroupInspMapper.maintain(guChId, setmealId);
		return res;
	}
}
