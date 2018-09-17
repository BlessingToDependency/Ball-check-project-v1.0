package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.entity.Dept;
import org.great.mapper.DeptMapper;
import org.springframework.stereotype.Service;

@Service
public class DeptBizImpl implements DeptBiz {

	@Resource
	private DeptMapper mapper;

	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

}
