package org.great.bean;

/*
 * 小结记录表
 * 
 */
public class SmallBean {
   private int sumId;//小结记录ID
   private  String guChId;//导检单ID
   private int itemId;//项目ID
   private  String doctor;//医生名
   private  String sumCont;//小结内容
   
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
   
   
   
}
