/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午10:30:36 
 */
package org.great.biz;

import java.util.List;

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
}
