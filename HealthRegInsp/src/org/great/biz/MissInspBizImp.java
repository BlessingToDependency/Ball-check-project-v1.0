package org.great.biz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.great.bean.DeparBean;
import org.great.bean.LitemBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.mapper.IGroupInspMapper;
import org.great.mapper.IUserMapper;
import org.great.search.BatchSheetCon;
import org.great.search.CompanyCon;
import org.great.search.MedicalCheckup;
import org.great.tools.Printing;
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
	//得到  员工导检单关系表  中的 人员导检
	@Override
	public PerguirelaBean getPerInspId(String partYear, int companyId, int batchNum, int staffId) {
		PerguirelaBean pgb =iGroupInspMapper.getPerInspId(partYear, companyId, batchNum, staffId);
		return pgb;
	}
	//更新 员工表中的  最新导检单号字段内容
	@Override
	public int updateNewGuChid(int staffId, String myGuChId,String time) {
		int res = iGroupInspMapper.updateNewGuChid(staffId, myGuChId,time);
		return res;
	}
	//维护导检单ID 和 对应 套餐表
	@Override
	public int intoGucHSet(int setmealId, int perInspId, String guChId) {
		int res = iGroupInspMapper.intoGucHSet(setmealId, perInspId, guChId);
		return res;
	}
	//获取用户体检的套餐ID集合
	@Override
	public List<Integer> setMeaList(int perInspId) {
		 List<Integer> list = iGroupInspMapper.setMeaList(perInspId);
		return list;
	}
	//获取用户体检的套餐ID集合
	@Override
	public List<Integer> itemList(int setmealId) {
		 List<Integer> list = iGroupInspMapper.itemList(setmealId);
		return list;
	}
	//维护  <导检单对应项目表>
	@Override
	public int intoGuChItem(int itemId, String guChId) {
		int res = iGroupInspMapper.intoGuChItem(itemId, guChId);
		return res;
	}
	 //把员工中的状态改为已经打印
	@Override
	public int updatePrint(int staffId) {
		int res = iGroupInspMapper.updatePrint(staffId);
		return res;
	}
	  //得到员工信息
	@Override
	public StaffBean getStaffInfo(int staffId) {
		return iGroupInspMapper.getStaffInfo(staffId);
	}
	   //添加影像ID
	@Override
	public int addImages(String guChId, String filename, int itemId) {
		int res= iGroupInspMapper.addImages(guChId, filename, itemId);
		return res;
	}
	//在本地硬盘上生成导检单
	@Override
	public int addConInspSheet(List<Integer> itemList,MedicalCheckup mck) {
		//得到单位名称
		UserBean company = iGroupInspMapper.getCompany(mck.getCompanyId());
		//得到与人员信息
		StaffBean staff = iGroupInspMapper.getStaffInfo(mck.getStaffId());
		mck.setAge(staff.getAge());
		mck.setCompany(company.getCompany());
		mck.setSex(staff.getSex());
		mck.setName(staff.getStaffName());
		mck.setId(staff.getIdNum());
		mck.setPhone(""+staff.getPhone());
		 //得到当前系统时间
	      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
	      String time = df.format(new Date());
		mck.setPrintTime(time);
	
		int itemId1 = itemList.get(0);
		//得到项目情况
		LitemBean item1 = iGroupInspMapper.getItemInfo(itemId1);
		mck.setItem1(item1.getItem());
		mck.setDescribe1(item1.getIntrod());
		//得到科室信息
		DeparBean depar1 = iGroupInspMapper.getDeparInfo(itemId1);
		mck.setDept1(depar1.getDepa());
		
		int itemId2 = itemList.get(1);
		//得到项目情况
		LitemBean item2 = iGroupInspMapper.getItemInfo(itemId2);
		mck.setItem2(item2.getItem());
		mck.setDescribe2(item2.getIntrod());
		//得到科室信息
		DeparBean depar2 = iGroupInspMapper.getDeparInfo(itemId2);
		mck.setDept2(depar2.getDepa());
		
		int itemId3 = itemList.get(2);
		//得到项目情况
		LitemBean item3 = iGroupInspMapper.getItemInfo(itemId3);
		mck.setItem3(item3.getItem());
		mck.setDescribe3(item3.getIntrod());
		//得到科室信息
		DeparBean depar3 = iGroupInspMapper.getDeparInfo(itemId3);
		mck.setDept3(depar3.getDepa());
		
		int itemId4 = itemList.get(3);
		//得到项目情况
		LitemBean item4 = iGroupInspMapper.getItemInfo(itemId4);
		mck.setItem4(item4.getItem());
		mck.setDescribe4(item4.getIntrod());
		//得到科室信息
		DeparBean depar4 = iGroupInspMapper.getDeparInfo(itemId4);
		mck.setDept4(depar4.getDepa());
		
		int itemId5 = itemList.get(4);
		//得到项目情况
		LitemBean item5 = iGroupInspMapper.getItemInfo(itemId5);
		mck.setItem5(item5.getItem());
		mck.setDescribe5(item5.getIntrod());
		//得到科室信息
		DeparBean depar5 = iGroupInspMapper.getDeparInfo(itemId5);
		mck.setDept5(depar5.getDepa());
		
		//生成导检单到本地
		Printing p = new Printing();
		try {
			p.exportSimpleWord(mck);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	} 
}
