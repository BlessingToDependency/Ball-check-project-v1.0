package org.great.mapper;

import java.util.List;

import org.great.bean.ParamBean;
import org.springframework.stereotype.Repository;


/*
 * 参数Mapper
 */
@Repository
public interface IParamMapper {
	//获取参数内容
	public List<ParamBean> ParamList();

}
