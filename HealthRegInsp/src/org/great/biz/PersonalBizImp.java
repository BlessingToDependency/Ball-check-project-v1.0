package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.BillBean;
import org.great.bean.PersonalBean;
import org.great.mapper.PersonalService;
import org.springframework.stereotype.Service;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 账单业务实现类 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-08 20:50 
*/ 
@Service
public class PersonalBizImp implements PersonalBiz{

	@Resource
	private PersonalService personalService;//个人账单接口
	
	//查询指定公司的某个账单下的所有个人账单
	@Override
	public List<PersonalBean> selectPersonal(BillBean billBean) {
		// TODO Auto-generated method stub
		List<PersonalBean> list = personalService.selectPersonal(billBean);
		return list;
	}

}
