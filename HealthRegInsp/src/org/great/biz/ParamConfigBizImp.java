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
	
	//删除系统参数
	@Override
	public int DelParam(int pid) {
		int res = iParamMapper.delParam(pid);
		return res;
	}

	//根据系统参数得到参数信息
	@Override
	public ParamBean getParamInfo(int pid) {
		ParamBean pb = iParamMapper.getParamInfo(pid);
		return pb;
	}

	//保存修改后后的参数内容
	@Override
	public int updateParam(ParamBean param) {
		int res = iParamMapper.updateParam(param);
		return res;
	}

}
