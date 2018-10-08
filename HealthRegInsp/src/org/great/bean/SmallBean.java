package org.great.bean;

import org.springframework.stereotype.Component;

/*
 * 小结记录表
 * 
 */
@Component
public class SmallBean {
   private int sumId;//小结记录ID
   private  String guChId;//导检单ID
   private int itemId;//项目ID
   private  String doctor;//医生名
   private  String sumCont;//小结内容SMALLSTATE
   
   private  FinresultBean finresultBean;  //细项结果表
   private  LitemBean litemBean;  //细项表  
   private  StaffBean staffBean;  //员工表
   
   
   
   public SmallBean() {
	   
   }
   
   
public SmallBean(int sumId, String guChId, int itemId, String doctor, String sumCont) {
	super();
	this.sumId = sumId;
	this.guChId = guChId;
	this.itemId = itemId;
	this.doctor = doctor;
	this.sumCont = sumCont;
}






/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "SmallBean [sumId=" + sumId + ", guChId=" + guChId + ", itemId=" + itemId + ", doctor=" + doctor
			+ ", sumCont=" + sumCont + ", finresultBean=" + finresultBean + ", litemBean=" + litemBean + ", staffBean="
			+ staffBean + "]";
}


public int getSumId() {
	return sumId;
}
public void setSumId(int sumId) {
	this.sumId = sumId;
}
public String getGuChId() {
	return guChId;
}
public void setGuChId(String guChId) {
	this.guChId = guChId;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public String getDoctor() {
	return doctor;
}
public void setDoctor(String doctor) {
	this.doctor = doctor;
}
public String getSumCont() {
	return sumCont;
}
public void setSumCont(String sumCont) {
	this.sumCont = sumCont;
}


/**
 * @return the finresultBean
 */
public FinresultBean getFinresultBean() {
	return finresultBean;
}


/**
 * @param finresultBean the finresultBean to set
 */
public void setFinresultBean(FinresultBean finresultBean) {
	this.finresultBean = finresultBean;
}


/**
 * @return the litemBean
 */
public LitemBean getLitemBean() {
	return litemBean;
}


/**
 * @param litemBean the litemBean to set
 */
public void setLitemBean(LitemBean litemBean) {
	this.litemBean = litemBean;
}


/**
 * @return the staffBean
 */
public StaffBean getStaffBean() {
	return staffBean;
}


/**
 * @param staffBean the staffBean to set
 */
public void setStaffBean(StaffBean staffBean) {
	this.staffBean = staffBean;
}


   
   
   
}
