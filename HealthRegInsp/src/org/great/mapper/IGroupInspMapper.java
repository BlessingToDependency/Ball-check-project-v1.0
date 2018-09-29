package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.PerguirelaBean;
import org.great.bean.StaffBean;
import org.great.bean.UserBean;
import org.great.search.BatchSheetCon;
import org.great.search.CompanyCon;
import org.springframework.stereotype.Repository;
/*
 * 团检开单
 */
@Repository
public interface IGroupInspMapper {
	//获取团检单位列表
	public List<UserBean> unitList(CompanyCon companyCon);
	
	//获取团检单位列表
	public List<UserBean> allUnitList(CompanyCon companyCon);
	
	//获取对应公司人员列表(分页、模糊)
	public List<StaffBean> staffList(BatchSheetCon batchSheetCon);
	
	//获取对应公司人员列表(总的、模糊)
	public List<StaffBean> allStaffList(BatchSheetCon batchSheetCon);
	
	//获取公司开单的年份
	public List<String> years(@Param("companyId")int companyId);
	
	//得到对应公司年份的批次号
	public List<String> batchNum(@Param("partYear")String partYear,@Param("companyId")int companyId);

    //得到员工的套餐ID
	public List<String> setMealid(@Param("smid")int smid);
	
	 //维护导检单对应套餐
	public int maintain(@Param("guChId")String guChId,@Param("setmealId")int setmealId);
	
	//得到  员工导检单关系表  中的 人员导检ID
	public PerguirelaBean  getPerInspId(@Param("partYear")String partYear,@Param("companyId")int companyId,@Param("batchNum")int batchNum,@Param("staffId")int staffId);
	
	//更新 员工表中的  最新导检单号字段内容
	public int updateNewGuChid(@Param("staffId")int staffId,@Param("myGuChId")String myGuChId);
	
	//维护导检单ID 和 对应 套餐表
	public int intoGucHSet(@Param("setmealId")int setmealId,@Param("perInspId")int perInspId,@Param("guChId")String guChId);
	
	//获取用户体检的套餐ID集合
	public List<Integer> setMeaList(@Param("perInspId")int perInspId);
	
	//获取用户体检的套餐ID集合
    public List<Integer> itemList(@Param("setmealId")int setmealId);
    
   //维护  <导检单对应项目表>
    public int intoGuChItem(@Param("itemId")int itemId,@Param("guChId")String guChId);
    
    //把员工中的状态改为已经打印
    public int updatePrint(@Param("staffId")int staffId);
}
