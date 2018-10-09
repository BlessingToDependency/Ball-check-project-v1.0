package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.RefundBean;
import org.springframework.stereotype.Repository;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 退款记录Service 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-08 23:21 
*/ 
@Repository
public interface Refundservice {

	//插入退款记录
	public void insertRefund(RefundBean refundBean);
	
	//分页查询所有的账单
	public List<RefundBean> selectRefund(@Param("page") Integer page);
	
	//查询账单总条数
	public Integer selectRefundSum();
	
	//更改状态
	public void updateRefund(@Param("id") Integer id,@Param("refundId") Integer refundId);
}
