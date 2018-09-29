/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午9:46:52 
 */
package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.SmallBean;
import org.great.bean.StaffBean;
import org.great.bean.TotalBean;

/** 
 * @ClassName: ReportBiz 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午9:46:52  
 */
public interface ReportBiz {

	//总结报告展示
	public TotalBean  showReport(String reportId);
	

	//展示总结单
	public List<BillBean> showCompany(String company,Integer currentPage);
	
	//计算总结单页数
	public  Integer  countPage(String company);
	
	//点击公司展开用户
	public List<StaffBean> findUserById (Integer companyId,PerguirelaBean pBean,String staffName);
	
	//用户计算分页
    public Integer countUser(Integer companyId,PerguirelaBean pBean,String staffName);
	
    //得到月份
    public  List<String>  queryYear();
    
    //得到批次号
    public List<Integer> queryBatch(PerguirelaBean pBean);
    
    
	 //得到小结
    public List<SmallBean> querySmall(Integer staffId);
    
    //插入总结
    public void insertTotal(TotalBean totalBean);
}