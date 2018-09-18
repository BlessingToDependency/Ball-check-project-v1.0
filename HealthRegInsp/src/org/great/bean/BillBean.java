package org.great.bean;

/*
 * 账单记录表
 */
public class BillBean {
   private int billId;//账单ID
   private int companyId;//公司ID
   private int ordNum;//预约人数
   private int actNum;//实际人数
   private int setmealId;//套餐ID
   private int actCharge;//实际收费
   
   public BillBean() {
	   
   }
   
   
public BillBean(int billId, int companyId, int ordNum, int actNum, int setmealId, int actCharge) {
	super();
	this.billId = billId;
	this.companyId = companyId;
	this.ordNum = ordNum;
	this.actNum = actNum;
	this.setmealId = setmealId;
	this.actCharge = actCharge;
}

public int getBillId() {
	return billId;
}
public void setBillId(int billId) {
	this.billId = billId;
}
public int getCompanyId() {
	return companyId;
}
public void setCompanyId(int companyId) {
	this.companyId = companyId;
}
public int getOrdNum() {
	return ordNum;
}
public void setOrdNum(int ordNum) {
	this.ordNum = ordNum;
}
public int getActNum() {
	return actNum;
}
public void setActNum(int actNum) {
	this.actNum = actNum;
}
public int getSetmealId() {
	return setmealId;
}
public void setSetmealId(int setmealId) {
	this.setmealId = setmealId;
}
public int getActCharge() {
	return actCharge;
}
public void setActCharge(int actCharge) {
	this.actCharge = actCharge;
}
   
   
   
   
}
