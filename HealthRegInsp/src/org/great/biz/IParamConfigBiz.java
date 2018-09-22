package org.great.biz;

import java.util.List;

import org.great.bean.ParamBean;

/*
 * 参数配Biz接口
 */
public interface IParamConfigBiz {
	//显示参数配置列表
	public List<ParamBean> ParamList(int statrRn,int endRn);
	
	//获取总的参数列表
	public List<ParamBean> allParamList();
	
	//获取所有的父级参数
	public List<ParamBean> allParamPar();
	
	//删除系统参数
	public int DelParam(int pid);
	
	//根据系统参数得到参数信息
	public ParamBean getParamInfo(int pid);
	
	//保存修改后后的参数内容
	public int updateParam(ParamBean param);
	
	//添加参数
	public int addParam(ParamBean param);


}
