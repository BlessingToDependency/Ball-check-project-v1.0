package org.great.bean;

/*
 * 员工表
 * 
 */
public class StaffBean {
     private int staffId;//员工ID
     private String staffName;//员工名
     private int age;//年龄
     private String sex;//性别
     private String idNum;//身份证号
     private int phone;//电话
     private int companyId;//公司ID
     
     public StaffBean(){
    	 
     }
     
	public StaffBean(int staffId, String staffName, int age, String sex, String idNum, int phone, int companyId) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.age = age;
		this.sex = sex;
		this.idNum = idNum;
		this.phone = phone;
		this.companyId = companyId;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
     
     
     
}
