package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.StaffBean;
import org.great.search.SumCon;
import org.springframework.stereotype.Repository;


/*
 * 医生小结Mapper
 */
@Repository
public interface ISummaryMapper {
	
	//根绝科室ID得到项目ID
	public List<StaffBean> getThisItemStaff(SumCon sunCon);
	
	//根绝科室ID得到项目ID
	public List<StaffBean> getAllThisItemStaff(SumCon sunCon);
	
}
