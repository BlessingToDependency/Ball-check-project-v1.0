package org.great.biz;

import java.util.List;

import org.great.bean.TermBean;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 细项业务抽象类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-24 20:58 
*/ 
public interface ParticularBiz {

	//查询所有的细项
	public List<TermBean> selectAllTerm();
}
