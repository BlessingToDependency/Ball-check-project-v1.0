package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.bean.TermBean;
import org.springframework.stereotype.Repository;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 账单service 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-07 21:16 
*/ 
@Repository
public interface BillService {
	
	//分页模糊查询对应公司账单
	public List<BillBean> selectAllBill(@Param("startTime") String startTime,@Param("endTime") String endTime,
			@Param("paramId") String paramId,@Param("page") Integer page,@Param("companyId") Integer companyId);
	
	//查询模糊条件账单总条数
	public Integer selectBillSum(@Param("startTime") String startTime,@Param("endTime") String endTime,
			@Param("paramId") String paramId,@Param("companyId") Integer companyId);
	
	//更改支付状态
	public void updateBill(@Param("id") Integer id,@Param("companyId") Integer companyId);
}
