package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.ParamBean;
import org.springframework.stereotype.Repository;


/*
 * 参数Mapper
 */
@Repository
public interface IParamMapper {
	//获取参数内容
	public List<ParamBean> ParamList();
	
	//删除系统参数
	public int delParam(@Param("pid")int pid);
	
	//根据参数ID得到对应的参数信息
	public ParamBean getParamInfo(@Param("pid")int pid);
	
	//保存修改的参数内容
	public int updateParam(ParamBean param);

}
