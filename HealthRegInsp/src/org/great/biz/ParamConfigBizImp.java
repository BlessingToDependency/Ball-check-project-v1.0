package org.great.biz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.great.bean.ParamBean;
import org.great.bean.UserBean;
import org.great.mapper.IParamMapper;
import org.springframework.stereotype.Service;
/*
 * 参数配Biz实现类
 */
@Service
public class ParamConfigBizImp implements IParamConfigBiz {
	@Resource
	private IParamMapper iParamMapper;
	//显示体检单位列表
	@Override
	public List<ParamBean> ParamList() {
		List<ParamBean> paramList = new ArrayList<ParamBean>();
		paramList=iParamMapper.ParamList();
		return paramList;
	}

}
