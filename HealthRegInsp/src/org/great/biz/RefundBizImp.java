package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.great.bean.RefundBean;
import org.great.mapper.Refundservice;
import org.springframework.stereotype.Service;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 退款记录业务实现类 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-08 23:32 
*/ 
@Service
public class RefundBizImp implements RefundBiz{

	@Resource
    private Refundservice refundservice;//账单退款接口
	
	//插入退款记录
	@Override
	public void insertRefund(RefundBean refundBean) {
		// TODO Auto-generated method stub
		refundservice.insertRefund(refundBean);
		
	}
	
	//分页查询所有的账单
	@Override
	public List<RefundBean> selectRefund(Integer page) {
		// TODO Auto-generated method stub
		List<RefundBean> list = refundservice.selectRefund(page);
		return list;
	}

	//查询账单总条数
	@Override
	public Integer selectRefundSum() {
		// TODO Auto-generated method stub	
		Integer sum = refundservice.selectRefundSum();
		return sum;
	}

	//更改状态
	@Override
	public void updateRefund(Integer id, Integer refundId) {
		// TODO Auto-generated method stub
		refundservice.updateRefund(id, refundId);
		
	}

}
