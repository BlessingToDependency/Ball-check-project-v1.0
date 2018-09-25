/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午10:30:36 
 */
package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.LitemBean;
import org.great.bean.SetmealBean;

/** 
 * @ClassName: OderBiz 
 * @Description: 显示套餐
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午10:30:36  
 */
public interface OderBiz {

	//套餐模糊搜索
	public  List<SetmealBean>  showOder(String setmeal,Integer currentPage); 
	
	//套餐页数总结
	public Integer   countOrder(String setmeal);
		
	//查询套餐中的项目
	public  List<LitemBean> findItemById (Integer setmealId);
	
	//删除套餐
	public  void  deleteOrder(Integer setmealId);
	
	
	//删除套餐中的项目
	public void deleteItem(Integer comId);
	
	//增加套餐	public void addOrder(@Param(value="setmealBean")SetmealBean setmealBean,@Param(value="myPic")String myPic);
	public void addOrder(SetmealBean setmealBean,String myPic);
	
	//增加套餐中的项目
   public void addItem(Integer setmealId,Integer itemId);
   
   	//修改套餐名
 	public void updateOrder(Integer setmealId,String setmeal);
	
}
