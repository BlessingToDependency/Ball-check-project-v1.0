/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年10月7日 下午3:52:15 
 */
package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.StaffBean;
import org.great.mapper.ComplexQuery;
import org.springframework.stereotype.Service;

/** 
 * @ClassName: QueryBizImp 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月7日 下午3:52:15  
 */
@Service("queryBizImp")
public class QueryBizImp implements QueryBiz{

	@Resource
	public ComplexQuery complexQuery;
	
	/* 展示总结人员
	 * @see org.great.biz.QueryBiz#queryAll(org.great.bean.StaffBean)
	 */
	
	@Override
	public List<StaffBean> queryAll(StaffBean staffBean) {
		
		List<StaffBean> list  =  complexQuery.queryAll(staffBean);
	
		return list;			
	}

	/* (non-Javadoc)
	 * @see org.great.biz.QueryBiz#addCount(org.great.bean.StaffBean)
	 */
	@Override
	public Integer addCount(StaffBean staffBean) {
		Integer count = complexQuery.addCount(staffBean);
		return count;
	}

}
