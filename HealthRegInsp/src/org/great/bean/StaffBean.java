package org.great.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * 员工表
 */
@Component
public class StaffBean {
     private int staffId;//员工ID
     private String staffName;//员工名
     private int age;//年龄
     private String sex;//性别
     private String idNum;//身份证号
     private long phone;//电话
     private int companyId;//公司ID
     private int medicalId;//体检状态
     private String newGuChId;//最新导检单号
     
     private String statTime;//开始时间
     private String stopTime;//结束时间
     
     @Resource
     private UserBean userBean;//前台公司表
     @Resource
     private PerguirelaBean perguirelaBean;//员工导检单关系表
     
	
	public StaffBean() {
		super();
	}
	
	

	public int getStaffId() {
		return staffId;
	}



	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}



	public String getStaffName() {
		return staffName;
	}



	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getIdNum() {
		return idNum;
	}



	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}



	public long getPhone() {
		return phone;
	}



	public void setPhone(long phone) {
		this.phone = phone;
	}



	public int getCompanyId() {
		return companyId;
	}



	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}



	public int getMedicalId() {
		return medicalId;
	}



	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}



	public String getNewGuChId() {
		return newGuChId;
	}



	public void setNewGuChId(String newGuChId) {
		this.newGuChId = newGuChId;
	}



	public String getStatTime() {
		return statTime;
	}



	public void setStatTime(String statTime) {
		this.statTime = statTime;
	}



	public String getStopTime() {
		return stopTime;
	}



	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}



	public UserBean getUserBean() {
		return userBean;
	}



	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}



	public PerguirelaBean getPerguirelaBean() {
		return perguirelaBean;
	}



	public void setPerguirelaBean(PerguirelaBean perguirelaBean) {
		this.perguirelaBean = perguirelaBean;
	}



	@Override
	public String toString() {
		return "StaffBean [staffId=" + staffId + ", staffName=" + staffName + ", age=" + age + ", sex=" + sex
				+ ", idNum=" + idNum + ", phone=" + phone + ", companyId=" + companyId + ", medicalId=" + medicalId
				+ ", newGuChId=" + newGuChId + ", statTime=" + statTime + ", stopTime=" + stopTime + ", userBean="
				+ userBean + ", perguirelaBean=" + perguirelaBean + "]";
	}


     
     
}
