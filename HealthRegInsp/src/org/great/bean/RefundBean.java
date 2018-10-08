package org.great.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 退款记录表实例化 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-08 23:10 
*/ 
@Component
public class RefundBean {
	
	private Integer refundId;//个人账单ID
	private Integer billId;//账单ID
	private Integer companyId;//公司ID
	private String reAmount;//退款金额
	private String reInfo;//退款理由
	private Integer paramId;//状态ID
	
	@Resource
	private ParamBean paramBean;

	public RefundBean() {
		// TODO Auto-generated constructor stub
	}

	public Integer getRefundId() {
		return refundId;
	}

	public void setRefundId(Integer refundId) {
		this.refundId = refundId;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getReAmount() {
		return reAmount;
	}

	public void setReAmount(String reAmount) {
		this.reAmount = reAmount;
	}

	public String getReInfo() {
		return reInfo;
	}

	public void setReInfo(String reInfo) {
		this.reInfo = reInfo;
	}

	@Override
	public String toString() {
		return "RefundBean [refundId=" + refundId + ", billId=" + billId + ", companyId=" + companyId + ", reAmount="
				+ reAmount + ", reInfo=" + reInfo + "]";
	}

	public ParamBean getParamBean() {
		return paramBean;
	}

	public void setParamBean(ParamBean paramBean) {
		this.paramBean = paramBean;
	}

	public Integer getParamId() {
		return paramId;
	}

	public void setParamId(Integer paramId) {
		this.paramId = paramId;
	}
	
}
