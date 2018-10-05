/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.mapper 
 * @author: wjx(wangj)   
 * @date: 2018年10月1日 上午11:56:09 
 */
package org.great.mapper;

import java.util.List;

import org.great.bean.SetmealBean;
import org.great.bean.TblChannel;
import org.great.bean.TblStatistics;
import org.springframework.stereotype.Repository;

/** 
 * @ClassName: StatisticMapper 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月1日 上午11:56:09  
 */
@Repository
public interface StatisticMapper {

	//统计注册公司数量
	public Integer getCount(TblStatistics sta);
	
	
	//统计套餐数量
    public Integer  orderCount(TblChannel channel);
	
    
    //得到套餐
    public List<SetmealBean>  queryOrder (TblChannel channel);
}
