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

import org.apache.ibatis.annotations.Param;
import org.great.bean.ItemConBean;
import org.great.bean.LitemBean;
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

	/* 查询套餐中的项目
	 * @see org.great.biz.OderBiz#findItemById(java.lang.Integer)
	 */
	@Override
	public List<LitemBean> findItemById(Integer setmealId) {
	
		List<LitemBean> list  = orderMapper.findItemById(setmealId);
		
		
		return list;
	}

	/* 删除套餐
	 * @see org.great.biz.OderBiz#deleteOrder(java.lang.Integer)
	 */
	@Override
	public void deleteOrder(Integer setmealId) {
		
		orderMapper.deleteOrder(setmealId);
	}

	/* 删除套餐中的项目
	 * @see org.great.biz.OderBiz#deleteItem(java.lang.Integer)
	 */
	@Override
	public void deleteItem(Integer comId) {
		
		orderMapper.deleteItem(comId);
	}

	/* (non-Javadoc)
	 * @see org.great.biz.OderBiz#addOrder(org.great.bean.SetmealBean)
	 */
	@Override
	public void addOrder(SetmealBean setmealBean,String myPic) {
	
		orderMapper.addOrder(setmealBean, myPic);
	}

	/* 增加套餐中的项目
	 * @see org.great.biz.OderBiz#addItem(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void addItem(Integer setmealId, Integer itemId) {
		
		orderMapper.addItem(setmealId, itemId);
	}

	/* (non-Javadoc)
	 * @see org.great.biz.OderBiz#updateOrder(java.lang.Integer, java.lang.String)
	 */
	@Override
	public void updateOrder(Integer setmealId, String setmeal) {
		
		orderMapper.updateOrder(setmealId, setmeal);		
	}

	/* (non-Javadoc)
	 * @see org.great.biz.OderBiz#queryItemById(org.great.bean.LitemBean, org.great.bean.ItemConBean, java.lang.Integer)
	 */
	@Override
	public List<LitemBean> queryItemById(LitemBean litemBean, ItemConBean itemBean, Integer setmealId) {
	
		return orderMapper.queryItemById(litemBean, itemBean, setmealId);
	}

	/* (non-Javadoc)
	 * @see org.great.biz.OderBiz#sumOrderByItem(org.great.bean.ItemConBean, java.lang.Integer)
	 */
	@Override
	public Integer sumOrderByItem(LitemBean litemBean,ItemConBean itemConBean, Integer setmealId) {
		
		return orderMapper.sumOrderByItem(litemBean, itemConBean, setmealId);
	}

	
	

	

}
