package org.great.biz;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.AdminBean;
import org.great.bean.StaffBean;
import org.great.mapper.IParamMapper;
import org.great.mapper.ISummaryMapper;
import org.great.search.SumCon;
import org.springframework.stereotype.Repository;

/*
 * 医生小结实现类
 */
@Repository
public class SummaryBizImp implements ISummaryBiz {
	@Resource
	private ISummaryMapper iSummaryMapper;
	
	//获得对应项目体检的人员列表
	@Override
	public List<StaffBean> getSummaryList(HttpServletRequest request,SumCon sunCon) {
		//得到登录对象信息
		AdminBean adminBean = (AdminBean) request.getSession().getAttribute("adminBean");
		//得到对应的科室Id
		int depaId = adminBean.getDepaId();
		sunCon.setDepaId(depaId);
		//得到了该项目还未做小结的导检单列表
		List<StaffBean> guChList = iSummaryMapper.getThisItemStaff(sunCon);
		return guChList;
	}
	//获得对应项目体检的人员列表(模糊查找)
	@Override
	public List<StaffBean> getAllSummaryList(HttpServletRequest request, SumCon sunCon) {
		//得到登录对象信息
		AdminBean adminBean = (AdminBean) request.getSession().getAttribute("adminBean");
		//得到对应的科室Id
		int depaId = adminBean.getDepaId();
		sunCon.setDepaId(depaId);
		//得到了该项目还未做小结的导检单列表
		List<StaffBean> guChList = iSummaryMapper.getAllThisItemStaff(sunCon);
		return guChList;
	}
	

}
