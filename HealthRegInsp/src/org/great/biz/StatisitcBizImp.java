/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年10月1日 上午11:53:37 
 */
package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.SetmealBean;
import org.great.bean.TblChannel;
import org.great.bean.TblStatistics;
import org.great.mapper.StatisticMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/** 
 * @ClassName: StatisitcBizImp 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月1日 上午11:53:37  
 */
@Service
public class StatisitcBizImp implements StatisitcBiz
{

	@Resource
	private StatisticMapper statisticMapper;
	/* (non-Javadoc)
	 * @see org.great.biz.StatisticBiz#getCount(org.great.bean.TblStatistics)
	 */
	@Override
	public Integer getCount(TblStatistics sta) {
		
			
		return statisticMapper.getCount(sta);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.StatisticBiz#orderCount(org.great.bean.TblChannel)
	 */
	@Override
	public Integer orderCount(TblChannel channel) {
		
		return statisticMapper.orderCount(channel);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.StatisticBiz#queryOrder(org.great.bean.TblChannel)
	 */
	@Override
	public List<SetmealBean> queryOrder(TblChannel channel) {
	
		return statisticMapper.queryOrder(channel);
	}

}
