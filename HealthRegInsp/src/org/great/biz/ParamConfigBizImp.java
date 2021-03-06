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
	public List<ParamBean> ParamList(int statrRn,int endRn) {
		List<ParamBean> paramList = new ArrayList<ParamBean>();
		paramList=iParamMapper.ParamList(statrRn,endRn);
		return paramList;
	}
	//获取总的参数列表
	@Override
	public List<ParamBean> allParamList() {
		List<ParamBean> paramList = new ArrayList<ParamBean>();
		paramList=iParamMapper.AllParamList();
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
	//获取所有的父级参数
	@Override
	public List<ParamBean> allParamPar() {
		List<ParamBean> paramList = new ArrayList<ParamBean>();
		paramList=iParamMapper.getParamPar();
		return paramList;
	}
	//添加参数
	@Override
	public int addParam(ParamBean param) {
		// TODO Auto-generated method stub
		int res = iParamMapper.addParam(param);
		return res;
	}


}
