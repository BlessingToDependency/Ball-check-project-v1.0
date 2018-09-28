package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.DeparBean;
import org.great.mapper.IDeparMapper;
import org.springframework.stereotype.Service;
@Service
public class DeparImp implements IdeparBiz {
	@Resource
	IDeparMapper iDeparMapper;
	
	//查询科室
	@Override
	public List<DeparBean> selectAllDepar() {
		// TODO Auto-generated method stub
		List<DeparBean> deparList=iDeparMapper.selectAllDepar();
		return deparList;
	}

	//带条件的分页查询科室
	@Override
	public List<DeparBean> selectDe(DeparBean deparBean, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		List<DeparBean> deList=iDeparMapper.selectDe(deparBean, rowBounds);
		return deList;
	}

	//去重，查询个数
	@Override
	public List<DeparBean> selectDeN(DeparBean deparBean) {
		// TODO Auto-generated method stub
		List<DeparBean> deList=iDeparMapper.selectDeN(deparBean);
		return deList;
	}

	//增加科室
	@Override
	public void innserDepar(String depar) {
		// TODO Auto-generated method stub
		
		iDeparMapper.innserDepar(depar);
	}

	//删除科室
	@Override
	public void deleteDepar(int depaId) {
		// TODO Auto-generated method stub
		iDeparMapper.deleteDepar(depaId);
	}

	//修改科室名
	@Override
	public void updateDepar(DeparBean deparBean) {
		// TODO Auto-generated method stub
		iDeparMapper.updateDepar(deparBean);
	}

}