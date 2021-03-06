/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年10月7日 下午3:54:08 
 */
package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.StaffBean;
import org.great.bean.TotalBean;

/** 
 * @ClassName: QueryBiz 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月7日 下午3:54:08  
 */
public interface QueryBiz  {

	//查询所有的信息
	public List<StaffBean>  queryAll(StaffBean staffBean );
	
	
	//体检综合查询计算条目数
    public  Integer  addCount(StaffBean staffBean);
    
    
    //得到总结信息
  	public TotalBean   showSummary(String guChId);
  	
  	
    //报告预览展示
  	public StaffBean findMyUser(StaffBean staffBean);
}
