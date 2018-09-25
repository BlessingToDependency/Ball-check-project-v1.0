/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.mapper 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午10:36:05 
 */
package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.LitemBean;
import org.great.bean.SetmealBean;
import org.springframework.stereotype.Repository;

/** 
 * @ClassName: IOrderMapper 
 * @Description: TODO
 * @author: wjx(wangj) 
 * @date: 2018年9月19日 下午10:36:05  
 */
@Repository
public interface OrderMapper {
	
	
	//显示套餐
	public List<SetmealBean> showMeal(@Param("setmeal")String setmeal,@Param("pagecount")Integer pagecount,@Param("currentPage")Integer currentPage);

	//计算套餐总条目数
	public  Integer totalPage(@Param("setmeal")String setmeal);
		
	//查询套餐中的项目
	public  List<LitemBean> findItemById (@Param("setmealId")Integer setmealId);
	
	//删除套餐中
	public  void  deleteOrder(@Param("setmealId")Integer setmealId);
	
	
	//删除套餐中的项目
	public void deleteItem(@Param("comId")Integer comId);
	
	
	//增加套餐中
	public void addOrder(@Param(value="setmealBean")SetmealBean setmealBean,@Param(value="myPic")String myPic);
	
	//增加套餐中的项目
	public void addItem(@Param("setmealId")Integer setmealId,@Param("itemId")Integer itemId);
	
	
	//修改套餐名 哈哈哈
	public void updateOrder(@Param("orderId")Integer setmealId,@Param("orderName")String setmeal);
	
}
