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
import org.great.bean.LitemBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.SmallBean;
import org.great.bean.StaffBean;
import org.great.bean.TermBean;
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
	
	//得到某个公司的所有员工	
	public List<StaffBean>  findGuChId(@Param("companyId")Integer companyId);
	
	
	//修改员工状态
	public void setSmall(@Param("myGuChId")String  myGuChId);
	
	//用户计算分页
    public Integer countUser(@Param("companyId")Integer companyId,@Param("pBean")PerguirelaBean pBean,@Param("staffName")String staffName);

    //得到年份
    public  List<String>  queryYear();
    
    //得到批次号
    public List<Integer> queryBatch(PerguirelaBean pBean);
    
    //得到小结
    public List<LitemBean> querySmall(StaffBean  staffBean);
       
    //插入总结
    public void insertTotal(TotalBean totalBean);
    
    //得到那个总结中的小结项目
    public List<SmallBean>  queryItem (StaffBean  staffBean);
    
    //得到小结项目中的科室
    public List<TermBean> querySection(SmallBean  staffBean);
    
   
    //判断小结
    public List<SmallBean> checkSmall(@Param("staffBean")StaffBean  staffBean ,@Param("itemId")Integer itemId);
    
    //得到小结个数 替代上面
    public Integer sumSmall(@Param("myGuChId")String  myGuChId );
    
    
    //计算套餐中的项目
    public Integer sumOrderItem (@Param("myGuChId")String  myGuChId  );
     
    
    //获取套餐中的项目
    public List<Integer> collectItem(StaffBean staffBean);
    
    
    //改变人员的体检状态
    public  void  changeState(TotalBean totalBean);
    
    //实际体检人数
    public void addUser(@Param("orderTime")String orderTime);
}
