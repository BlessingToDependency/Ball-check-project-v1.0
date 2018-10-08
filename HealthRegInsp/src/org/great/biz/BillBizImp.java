package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.great.bean.BillBean;
import org.great.mapper.BillService;
import org.springframework.stereotype.Service;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 账单业务实现类 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-08 00:48 
*/ 
@Service
public class BillBizImp implements BillBiz{

	@Resource
	private BillService billService;//账单Service
	
	//分页模糊查询对应公司账单
	@Override
	public List<BillBean> selectAllBill(String startTime, String endTime, String paramId, Integer page,Integer companyId) {
		// TODO Auto-generated method stub
		List<BillBean> list = billService.selectAllBill(startTime, endTime, paramId, page,companyId);
		return list;
	}

	//查询模糊条件账单总条数
	@Override
	public Integer selectBillSum(String startTime, String endTime, String paramId,Integer companyId) {
		// TODO Auto-generated method stub
		Integer sum = billService.selectBillSum(startTime, endTime, paramId,companyId);
		return sum;
	}

	//更改支付状态
	@Override
	public void updateBill(Integer id,Integer companyId) {
		// TODO Auto-generated method stub
		billService.updateBill(id,companyId);
	}

}
