/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午9:49:24 
 */
package org.great.biz;

import javax.annotation.Resource;

import org.great.bean.TotalBean;
import org.great.mapper.IReportMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/** 
 * @ClassName: ReportBizImp 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午9:49:24  
 */
@Repository
public class ReportBizImp implements ReportBiz {

	@Resource
	private IReportMapper iReportMapper;
	/* 展示总结报告表
	 * @see org.great.biz.ReportBiz#showReport(java.lang.Integer)
	 */
	@Override
	public TotalBean showReport(String reportId) {
		
		TotalBean totalBean = iReportMapper.showReport(reportId);
		return totalBean;
	}

}
