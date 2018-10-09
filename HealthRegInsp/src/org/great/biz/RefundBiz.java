package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.RefundBean;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 退款记录业务抽象类 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-08 23:31 
*/ 
public interface RefundBiz {
	
	//插入退款记录
	public void insertRefund(RefundBean refundBean);
	
	//分页查询所有的账单
	public List<RefundBean> selectRefund(@Param("page") Integer page);
	
	//查询账单总条数
	public Integer selectRefundSum();
	
	//更改状态
	public void updateRefund(@Param("id") Integer id,@Param("refundId") Integer refundId);

}
