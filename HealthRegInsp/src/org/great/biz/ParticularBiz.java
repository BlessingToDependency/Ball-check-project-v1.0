package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.TermBean;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 细项业务抽象类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-24 20:58 
*/ 
public interface ParticularBiz {

	//查询所有的细项
	public List<TermBean> selectAllTerm();
	
	//分页 模糊 条件 查询细项信息
	public List<TermBean> selectTerm(@Param(value="termBean") TermBean termBean,@Param("page") Integer page); 
	
	//查询模糊条件细项总条数
	public Integer selectTermSum(TermBean termBean);
	
	//增加细项
	public void addTerm(TermBean termBean);
	
	//查询单个细项信息
	public TermBean selectOneTerm(@Param("termId") Integer termId);
	
	//修改细项信息
	public void upDateTerm(TermBean termBean);
	
	//删除细项
	public void deleteTerm(@Param("termId") Integer termId);
	
	//删除项目细项关系中关于细项的数据
	public void deleteTermCom(@Param("termId") Integer termId);
}
