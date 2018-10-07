/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年10月1日 上午11:50:30 
 */
package org.great.biz;

import java.util.List;

import org.great.bean.SetmealBean;
import org.great.bean.TblChannel;
import org.great.bean.TblStatistics;

/** 
 * @ClassName: StatisticBiz 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月1日 上午11:50:30  
 */
public interface StatisitcBiz {

	
	//统计注册人数
	public Integer getCount(TblStatistics sta);
	
	//统计套餐数量
    public Integer  orderCount(TblChannel channel);
     
    //得到套餐
    public List<SetmealBean>  queryOrder (TblChannel channel);
}
