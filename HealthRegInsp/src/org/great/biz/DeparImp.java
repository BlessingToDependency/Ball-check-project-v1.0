package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.DeparBean;
import org.great.mapper.IDeparMapper;
import org.springframework.stereotype.Service;
@Service
public class DeparImp implements IdeparBiz {
	@Resource
	IDeparMapper iDeparMapper;
	
	@Override
	public List<DeparBean> selectAllDepar() {
		// TODO Auto-generated method stub
		List<DeparBean> deparList=iDeparMapper.selectAllDepar();
		return deparList;
	}

}
