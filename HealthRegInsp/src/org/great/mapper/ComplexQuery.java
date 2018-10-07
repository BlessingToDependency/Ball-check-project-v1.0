/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.mapper 
 * @author: wjx(wangj)   
 * @date: 2018年10月7日 下午4:01:50 
 */
package org.great.mapper;

import java.util.List;

import org.great.bean.StaffBean;
import org.springframework.stereotype.Repository;

/** 
 * @ClassName: ComplexQuery 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月7日 下午4:01:50  
 */
@Repository
public interface ComplexQuery {

	//体检综合查询
	public  List<StaffBean>  queryAll(StaffBean staffBean);
	
	//体检综合查询计算条目数
	public  Integer  addCount(StaffBean staffBean);
}
