package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.FinresultBean;
import org.great.bean.LitemBean;
import org.great.bean.StaffBean;
import org.great.search.GuchIDdItemID;
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
	
	//根据所在科室获得对应的小结页面
	public int getIntFace(@Param("depeId")int depeId);
	
	//根据所在科室找到对应的检查的项目
	public LitemBean getItem(@Param("depeId")int depeId);
	
	//根据导检单ID和项目ID得到该用户该项目细项结果
	public List<FinresultBean> getFinresultList(@Param("guChId")String guChId,@Param("itemId")int itemId);
	
	//提交小结内容
    public int subSumm(GuchIDdItemID giBean);
    
    //获得影视文件
    public List<String> imageFile(@Param("guChId")String guChId,@Param("itemId")int itemId);
    
    //根据导检单号和科室id查询该用户是否已经小结过了
    public String xiaoJie(@Param("guChId")String guChId,@Param("depaid")int depaid);
    
    //维护小结人员表
    public int addXiao(@Param("guChId")String guChId,@Param("depaid")int depaid);

    
    //根据导检单得到影像文件对应的项目id
    public int getItemIds(@Param("guChId")String guChId);

}
