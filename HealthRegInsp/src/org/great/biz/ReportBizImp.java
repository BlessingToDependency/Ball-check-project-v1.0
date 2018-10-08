/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午9:49:24 
 */
package org.great.biz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.bean.LitemBean;
import org.great.bean.PerguirelaBean;
import org.great.bean.SmallBean;
import org.great.bean.StaffBean;
import org.great.bean.TermBean;
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
	public Map<String, LitemBean>querySmall(StaffBean staffBean) {
	
		List<LitemBean> list  = reportMapper.querySmall(staffBean);
		Map<String, LitemBean> map = new  HashMap<String, LitemBean>();
		
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			LitemBean litemBean = (LitemBean) iterator.next();			
			map.put(litemBean.getItem(), litemBean);		
		}
	
	    Set set = map.keySet();
	    Iterator it = set.iterator();
	    while(it.hasNext()){
	        String key = (String) it.next();
	        LitemBean value = (LitemBean) map.get(key);
	        System.out.println(key + "=" + value);
	    }
		
		return map;
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#insertTotal(org.great.bean.TotalBean)
	 */
	@Override
	public void insertTotal(TotalBean totalBean) {
		
		 reportMapper.insertTotal(totalBean);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#queryItem(org.great.bean.StaffBean)
	 */
	@Override
	public List<SmallBean> queryItem(StaffBean staffBean) {
		
		return reportMapper.queryItem(staffBean);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#querySection(org.great.bean.StaffBean)
	 */
	@Override
	public List<TermBean> querySection(SmallBean  smallBean) {
		
		return reportMapper.querySection(smallBean);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#checkSmall(org.great.bean.SmallBean)
	 */
	@Override
	public List<SmallBean> checkSmall(StaffBean  staffBean ,Integer itemId) {
		
		
		
		return reportMapper.checkSmall( staffBean , itemId);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#collectItem(org.great.bean.StaffBean)
	 */
	@Override
	public List<Integer> collectItem(StaffBean staffBean) {
		
		return reportMapper.collectItem(staffBean);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#sumSmall(org.great.bean.StaffBean)
	 */
	@Override
	public Integer sumSmall(String  myGuChId ) {
		
		
		return reportMapper.sumSmall(myGuChId);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#sumOrderItem(org.great.bean.StaffBean)
	 */
	@Override
	public Integer sumOrderItem(String  myGuChId ) {
		// TODO Auto-generated method stub
		return reportMapper.sumOrderItem(myGuChId);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#findGuChId(java.lang.Integer)
	 */
	@Override
	public  List<StaffBean>  findGuChId(Integer companyId) {
		
		return reportMapper.findGuChId(companyId);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#setSmall(java.lang.String)
	 */
	@Override
	public void setSmall(String myGuChId) {
	
		reportMapper.setSmall(myGuChId);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#changeState(org.great.bean.TotalBean)
	 */
	@Override
	public void changeState(TotalBean totalBean) {
		
		reportMapper.changeState(totalBean);
	}
	/* (non-Javadoc)
	 * @see org.great.biz.ReportBiz#addUser(java.lang.String)
	 */
	@Override
	public void addUser(String orderTime) {
		
		reportMapper.addUser(orderTime);
	}



}
