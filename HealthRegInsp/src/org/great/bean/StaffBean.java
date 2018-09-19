package org.great.bean;

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
     
     private UserBean userBean;//前台公司表
     private PerguirelaBean perguirelaBean;//员工导检单关系表
     private GuisetmealBean guisetmealBean;//导检单套餐表
     
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

	public GuisetmealBean getGuisetmealBean() {
		return guisetmealBean;
	}

	public void setGuisetmealBean(GuisetmealBean guisetmealBean) {
		this.guisetmealBean = guisetmealBean;
	}
     
     
     
}
