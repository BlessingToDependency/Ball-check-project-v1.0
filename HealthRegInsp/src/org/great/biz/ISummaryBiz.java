package org.great.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.great.bean.StaffBean;
import org.great.search.SumCon;

/*
 * 医生小结
 */
public interface ISummaryBiz {
	//获得对应项目体检的人员列表(模糊查找、带分页)
	public List<StaffBean> getSummaryList(HttpServletRequest request,SumCon sunCon);
	
	//获得对应项目体检的人员列表(模糊查找)
	public List<StaffBean> getAllSummaryList(HttpServletRequest request,SumCon sunCon);
	
	
}
