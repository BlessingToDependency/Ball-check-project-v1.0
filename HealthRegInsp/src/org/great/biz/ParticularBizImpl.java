package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

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

}
