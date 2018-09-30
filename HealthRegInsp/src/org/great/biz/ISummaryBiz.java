package org.great.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.great.bean.FinresultBean;
import org.great.bean.LitemBean;
import org.great.bean.StaffBean;
import org.great.search.GuchIDdItemID;
import org.great.search.SumCon;

/*
 * 医生小结
 */
public interface ISummaryBiz {
	//获得对应项目体检的人员列表(模糊查找、带分页)
	public List<StaffBean> getSummaryList(HttpServletRequest request,SumCon sunCon);
	
	//获得对应项目体检的人员列表(模糊查找)
	public List<StaffBean> getAllSummaryList(HttpServletRequest request,SumCon sunCon);
	
	//根据所在科室获得对应的小结页面
	public int intFace(int depaId);
	
	//根据所在科室找到对应的检查的项目ID
    public LitemBean getItem(int depeId);
    
    //根据导检单ID和项目ID得到该用户该项目细项结果
  	public List<FinresultBean> getFinresultList(String guChId,int itemId);
	
    //提交小结内容
    public int subSumm(GuchIDdItemID giBean);
    
    //获得影视文件
    public List<String> imageFile(String guChId,int itemId);
}
