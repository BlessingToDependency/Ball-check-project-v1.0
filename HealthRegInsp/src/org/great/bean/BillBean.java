package org.great.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * 账单记录表
 */
@Component
public class BillBean {
   private int billId;//账单ID
   private int companyId;//公司ID
   private int ordNum;//预约人数
   private int actNum;//实际人数
   private int setmealId;//套餐ID
   private int actCharge;//实际收费
   private String currentTime;//当前时间
   private String orderTime;  //下单时间
   private UserBean userBean;  //后台用户表
   
   @Resource
   private ParamBean paramBean;//参数bean
   
   
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


public String getCurrentTime() {
	return currentTime;
}


public void setCurrentTime(String currentTime) {
	this.currentTime = currentTime;
}


/**
 * @return the orderTime
 */
public String getOrderTime() {
	return orderTime;
}


/**
 * @param orderTime the orderTime to set
 */
public void setOrderTime(String orderTime) {
	this.orderTime = orderTime;
}


/**
 * @return the userBean
 */
public UserBean getUserBean() {
	return userBean;
}


/**
 * @param userBean the userBean to set
 */
public void setUserBean(UserBean userBean) {
	this.userBean = userBean;
}


@Override
public String toString() {
	return "BillBean [billId=" + billId + ", companyId=" + companyId + ", ordNum=" + ordNum + ", actNum=" + actNum
			+ ", setmealId=" + setmealId + ", actCharge=" + actCharge + ", currentTime=" + currentTime + ", orderTime="
			+ orderTime + ", userBean=" + userBean + ", paramBean=" + paramBean + "]";
}


public ParamBean getParamBean() {
	return paramBean;
}


public void setParamBean(ParamBean paramBean) {
	this.paramBean = paramBean;
}



   
   
   
}
