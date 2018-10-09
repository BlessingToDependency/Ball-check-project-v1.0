package org.great.bean;

import org.springframework.stereotype.Component;

/*
 * 立即购买表
 */
@Component
public class BuyNowBean {
	private int buyNowId;//购买id
	private int companyId;//公司id
	private int setmealId;//套餐id
	private int buyNumber;//数量
	private int billId;//账单id
	
	private int staffId;//员工ID
	private int ordNum;//预约人数
	
	
	public BuyNowBean() {
		super();
	}
	public int getBuyNowId() {
		return buyNowId;
	}
	public void setBuyNowId(int buyNowId) {
		this.buyNowId = buyNowId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getSetmealId() {
		return setmealId;
	}
	public void setSetmealId(int setmealId) {
		this.setmealId = setmealId;
	}
	public int getBuyNumber() {
		return buyNumber;
	}
	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(int ordNum) {
		this.ordNum = ordNum;
	}
	
	
}
