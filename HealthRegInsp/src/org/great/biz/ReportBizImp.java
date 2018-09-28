/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午9:49:24 
 */
package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.SmallBean;
import org.great.bean.StaffBean;
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
	public  final static Integer pagecount = 5;
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
	/* 
	 * @see org.great.biz.ReportBiz#showCompany(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<BillBean> showCompany(String company, Integer currentPage) {
	
		return reportMapper.showCompany(company, pagecount, currentPage);
	}
	/* 
	 * @see org.great.biz.ReportBiz#countPage(java.lang.String)
	 */
	@Override
	public Integer countPage(String company) {
		
		return reportMapper.countPage(company);
	}

	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#findUserById(java.lang.Integer, org.great.bean.PerguirelaBean, java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<StaffBean> findUserById(Integer companyId, PerguirelaBean pBean, String staffName) {
		
		return reportMapper.findUserById(companyId, pBean, staffName, pagecount);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#countUser(org.great.bean.PerguirelaBean, java.lang.String)
	 */
	@Override
	public Integer countUser(Integer companyId,PerguirelaBean pBean, String staffName) {
		
		return reportMapper.countUser(companyId,pBean, staffName);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#queryYear()
	 */
	@Override
	public List<String> queryYear() {
		
		return reportMapper.queryYear();
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#queryBatch(org.great.bean.PerguirelaBean)
	 */
	@Override
	public List<Integer> queryBatch(PerguirelaBean pBean) {
	
		return reportMapper.queryBatch(pBean);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#querySmall(java.lang.Integer)
	 */
	@Override
	public List<SmallBean> querySmall(Integer staffId) {
	
		return reportMapper.querySmall(staffId);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#insertTotal(org.great.bean.TotalBean)
	 */
	@Override
	public void insertTotal(TotalBean totalBean) {
		
		 reportMapper.insertTotal(totalBean);
	}



}
