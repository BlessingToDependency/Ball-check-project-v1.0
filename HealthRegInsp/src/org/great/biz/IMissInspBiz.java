package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.PerguirelaBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.search.BatchSheetCon;
import org.great.search.CompanyCon;
import org.great.search.MedicalCheckup;

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
	
	//得到  员工导检单关系表  中的 人员导检ID
	public PerguirelaBean getPerInspId(String partYear,int companyId,int batchNum,int staffId);
	
	//更新 员工表中的  最新导检单号字段内容
	public int updateNewGuChid(int staffId,String myGuChId,String time);
	
	//维护导检单ID 和 对应 套餐表
	public int intoGucHSet(int setmealId,int perInspId,String guChId);
	
	//获取用户体检的套餐ID集合
	public List<Integer> setMeaList(int perInspId);
	
	//获取用户体检的套餐ID集合
    public List<Integer> itemList(int setmealId);
    
    //维护  <导检单对应项目表>
    public int intoGuChItem(int itemId,String guChId);
    
    //把员工中的状态改为已经打印
    public int updatePrint(int staffId);
    
    //得到员工信息
    public StaffBean getStaffInfo(int staffId);
    
    //添加影像ID
    public int addImages(String guChId,String filename,int itemId);
    
    //在本地硬盘上生成导检单
    public int addConInspSheet(List<Integer> itemList,MedicalCheckup mck);

}
