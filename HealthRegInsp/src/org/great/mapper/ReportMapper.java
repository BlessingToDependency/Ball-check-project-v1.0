/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.mapper 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午4:58:57 
 */
package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.SmallBean;
import org.great.bean.StaffBean;
import org.great.bean.TotalBean;
import org.springframework.stereotype.Repository;

/** 
 * @ClassName: IReportMapper 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午4:58:57  
 */
@Repository
public interface ReportMapper {

	//总结报告单
	public  TotalBean  showReport(@Param("guChId")String reportId);
	
	//展示总结单
	public List<BillBean> showCompany(@Param("company")String company,@Param("pagecount")Integer pagecount,@Param("currentPage")Integer currentPage);
	
	//计算总结单页数
	public  Integer  countPage(@Param("company")String company);
	
	
	//点击公司展开用户
	public List<StaffBean> findUserById (@Param("companyId")Integer companyId,@Param("pBean")PerguirelaBean pBean,@Param("staffName")String staffName,@Param("pagecount")Integer pagecount);
	
	
	//用户计算分页
    public Integer countUser(@Param("companyId")Integer companyId,@Param("pBean")PerguirelaBean pBean,@Param("staffName")String staffName);

    //得到年份
    public  List<String>  queryYear();
    
    //得到批次号
    public List<Integer> queryBatch(PerguirelaBean pBean);
    
    //得到小结
    public List<SmallBean> querySmall(@Param("staffId")Integer staffId);
       
    //插入总结
    public void insertTotal(TotalBean totalBean);
    
}
