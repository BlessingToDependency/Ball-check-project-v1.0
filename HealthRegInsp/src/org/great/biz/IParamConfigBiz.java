package org.great.biz;

import java.util.List;

import org.great.bean.ParamBean;

/*
 * 参数配Biz接口
 */
public interface IParamConfigBiz {
	//显示体检单位列表
	public List<ParamBean> ParamList();
	
	//删除系统参数
	public int DelParam(int pid);
	
	//根据系统参数得到参数信息
	public ParamBean getParamInfo(int pid);
	
	//保存修改后后的参数内容
	public int updateParam(ParamBean param);


}
