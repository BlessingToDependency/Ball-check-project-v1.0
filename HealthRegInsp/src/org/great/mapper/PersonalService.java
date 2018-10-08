package org.great.mapper;

import java.util.List;

import org.great.bean.BillBean;
import org.great.bean.PersonalBean;
import org.springframework.stereotype.Repository;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 个人账单Service 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-08 20:30 
*/ 
@Repository
public interface PersonalService {
	
	//查询指定公司的某个账单下的所有个人账单
	public List<PersonalBean> selectPersonal(BillBean billBean);
	
	

}
