/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午10:33:54 
 */
package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.SetmealBean;
import org.great.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/** 
 * @ClassName: OderBizImp 
 * @Description: 显示套餐
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午10:33:54  
 */
@Service("oderBizImp")
public class OderBizImp implements OderBiz{
	public  final static Integer pagecount = 5;
	
	@Resource
	public OrderMapper orderMapper;
	/* (non-Javadoc)
	 * @see org.great.biz.OderBiz#showOder(java.lang.String)
	 */
	@Override
	public List<SetmealBean> showOder(String setmeal,Integer currentPage) {
		
		List<SetmealBean> list =orderMapper.showMeal(setmeal, pagecount,currentPage); 
		return list;
	}

	/* (non-Javadoc)
	 * @see org.great.biz.OderBiz#countOrder(java.lang.String)
	 */
	@Override
	public Integer countOrder(String setmeal) {
		
		Integer count = orderMapper.totalPage(setmeal);
								
		return count;
	}

}
