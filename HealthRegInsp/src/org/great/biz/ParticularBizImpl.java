package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.great.bean.TermBean;
import org.great.mapper.IParticularService;
import org.springframework.stereotype.Service;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 细项业务抽象实现类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-24 21:00 
*/ 
@Service
public class ParticularBizImpl implements ParticularBiz{

	@Resource
	private IParticularService iParticularService;//细项接口
	
	//查询所有的细项
	@Override
	public List<TermBean> selectAllTerm() {
		// TODO Auto-generated method stub
		List<TermBean> list = iParticularService.selectAllTerm();
		return list;
	}
	
	//分页 模糊 条件 查询细项信息
	@Override
	public List<TermBean> selectTerm(TermBean termBean, Integer page) {
		// TODO Auto-generated method stub
		List<TermBean> list = iParticularService.selectTerm(termBean, page);
		return list;
	}

	//查询模糊条件细项总条数
	@Override
	public Integer selectTermSum(TermBean termBean) {
		// TODO Auto-generated method stub
		Integer sum = iParticularService.selectTermSum(termBean);
		return sum;
	}

	//增加细项
	@Override
	public void addTerm(TermBean termBean) {
		// TODO Auto-generated method stub
		iParticularService.addTerm(termBean);
		
	}

	//查询单个细项信息
	@Override
	public TermBean selectOneTerm(Integer termId) {
		// TODO Auto-generated method stub
		TermBean tb = iParticularService.selectOneTerm(termId);
		return tb;
	}

	//修改细项信息
	@Override
	public void upDateTerm(TermBean termBean) {
		// TODO Auto-generated method stub
		iParticularService.upDateTerm(termBean);
		
	}

	//删除细项
	@Override
	public void deleteTerm(Integer termId) {
		// TODO Auto-generated method stub
		iParticularService.deleteTerm(termId);
	}

	//删除项目细项关系中关于细项的数据
	@Override
	public void deleteTermCom(Integer termId) {
		// TODO Auto-generated method stub
		iParticularService.deleteTermCom(termId);
	}

	//细项查重
	@Override
	public List<TermBean> repetitionTerm(String term) {
		// TODO Auto-generated method stub
		List<TermBean> tb = iParticularService.repetitionTerm(term);
		return tb;
	}

}
