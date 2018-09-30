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
     private String napany;
     private int medicalId;//体检状态
     private String myGuChId ;//最新导检单号
     private int printGuCh; //打印导检单状态
     private int orderId;//预约状态


	private String statTime;//开始时间
     private String stopTime;//结束时间
     
     @Resource
     private UserBean userBean;//前台公司表
     @Resource
     private PerguirelaBean perguirelaBean;//员工导检单关系表
     
	
	public StaffBean() {
		super();
	}


	public StaffBean(int staffId, String staffName, int age, String sex, String idNum, long phone, int companyId,
			String napany, int medicalId, String myGuChId, int printGuCh, String statTime, String stopTime,
			UserBean userBean, PerguirelaBean perguirelaBean) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.age = age;
		this.sex = sex;
		this.idNum = idNum;
		this.phone = phone;
		this.companyId = companyId;
		this.napany = napany;
		this.medicalId = medicalId;
		this.myGuChId = myGuChId;
		this.printGuCh = printGuCh;
		this.statTime = statTime;
		this.stopTime = stopTime;
		this.userBean = userBean;
		this.perguirelaBean = perguirelaBean;
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


	public String getNapany() {
		return napany;
	}


	public void setNapany(String napany) {
		this.napany = napany;
	}


	public int getMedicalId() {
		return medicalId;
	}


	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}


	public String getMyGuChId() {
		return myGuChId;
	}


	public void setMyGuChId(String myGuChId) {
		this.myGuChId = myGuChId;
	}


	public int getPrintGuCh() {
		return printGuCh;
	}


	public void setPrintGuCh(int printGuCh) {
		this.printGuCh = printGuCh;
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


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	
     
     
}
