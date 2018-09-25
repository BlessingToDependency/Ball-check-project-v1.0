package org.great.mapper;

import java.util.List;

import org.great.bean.TermBean;
import org.springframework.stereotype.Repository;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 细项接口 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-24 20:29 
*/ 
@Repository
public interface IParticularService {

	//查询所有的细项
	public List<TermBean> selectAllTerm();
}
