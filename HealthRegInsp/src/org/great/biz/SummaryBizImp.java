package org.great.biz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.bean.AdminBean;
import org.great.bean.FinresultBean;
import org.great.bean.LitemBean;
import org.great.bean.StaffBean;
import org.great.mapper.IParamMapper;
import org.great.mapper.ISummaryMapper;
import org.great.search.GuchIDdItemID;
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
		
		List<StaffBean> List = new ArrayList<StaffBean>();
		for(int i =0;i<guChList.size();i++) {
			StaffBean stb = guChList.get(i);
			//得到该用户的导检单号
			String ch = stb.getMyGuChId();
			//根据导检单号和科室id查询该用户是否已经小结过了
			String x = iSummaryMapper.xiaoJie(ch, depaId);
			if(x==null) {
				List.add(stb);
			}
		}
		return List;
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
		List<StaffBean> List = new ArrayList<StaffBean>();
		for(int i =0;i<guChList.size();i++) {
			StaffBean stb = guChList.get(i);
			//得到该用户的导检单号
			String ch = stb.getMyGuChId();
			//根据导检单号和科室id查询该用户是否已经小结过了
			String x = iSummaryMapper.xiaoJie(ch, depaId);
			if(x==null) {
				List.add(stb);
			}
		}
		return List;
	}
	//根据所在科室获得对应的小结页面
	@Override
	public int intFace(int depaId) {
		
		return iSummaryMapper.getIntFace(depaId);
	}
	//根据所在科室找到对应的检查的项目ID
	@Override
	public LitemBean getItem(int depeId) {
		
		return iSummaryMapper.getItem(depeId);
	}
	 //根据导检单ID和项目ID得到该用户该项目细项结果
	@Override
	public List<FinresultBean> getFinresultList(String guChId, int itemId) {
		List<FinresultBean> finrList = iSummaryMapper.getFinresultList(guChId, itemId);
		return finrList;
	}
	
	//提交小结内容
	@Override
	public int subSumm(GuchIDdItemID giBean) {
		int res= iSummaryMapper.subSumm(giBean);
		return res;
	}
	 //获得影视文件
	@Override
	public List<String> imageFile(String guChId, int itemId) {
		List<String> list = iSummaryMapper.imageFile(guChId, itemId);
		return list;
	}
	//维护小结人员表
	@Override
	public int addXiao(String guChId, int depaid) {
		// TODO Auto-generated method stub
		return iSummaryMapper.addXiao(guChId, depaid);
	}

	 //根据导检单得到影像文件对应的项目id
	@Override
	public int getItemIds(String guChId) {
		// TODO Auto-generated method stub
		return iSummaryMapper.getItemIds(guChId);
	}

	

}
