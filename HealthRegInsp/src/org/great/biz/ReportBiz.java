/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午9:46:52 
 */
package org.great.biz;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.bean.LitemBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.SmallBean;
import org.great.bean.StaffBean;
import org.great.bean.TermBean;
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
    public  Map<String, LitemBean> querySmall(StaffBean staffBean);
    
     //插入总结
     public void insertTotal(TotalBean totalBean);
     
     //得到那个总结中的小结项目
     public List<SmallBean>  queryItem (StaffBean  staffBean);
     
     //得到小结项目中的科室
     public List<TermBean> querySection(SmallBean  smallBean);
     
     
     //判断小结是否都完成
     public List<SmallBean>   checkSmall(StaffBean  staffBean ,Integer itemId);
     
     //获取套餐中的项目
     public List<Integer> collectItem(StaffBean staffBean);
     
}