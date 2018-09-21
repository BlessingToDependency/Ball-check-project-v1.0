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
}
