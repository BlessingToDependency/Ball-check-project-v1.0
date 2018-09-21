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
import org.great.mapper.ReportMapper;
import org.springframework.stereotype.Service;

/** 
 * @ClassName: ReportBizImp 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午9:49:24  
 */
@Service
public class ReportBizImp implements ReportBiz {

	@Resource
	public ReportMapper reportMapper;
	/* 展示总结报告表
	 * @see org.great.biz.ReportBiz#showReport(java.lang.Integer)
	 */
	@Override
	public TotalBean showReport(String reportId) {
		System.out.println("reportId:"+reportId);
		TotalBean totalBean = reportMapper.showReport(reportId);
		System.out.println("totalBean:"+totalBean.toString());
		return totalBean;
	}

}
