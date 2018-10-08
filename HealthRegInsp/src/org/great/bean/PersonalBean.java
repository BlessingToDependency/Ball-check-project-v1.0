package org.great.bean;

import org.springframework.stereotype.Component;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 个人账单记录表实体类 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-08 20:17 
*/ 
@Component
public class PersonalBean {

	private Integer personalId;//个人账单ID
	private Integer companyId;//公司ID
	private Integer staffId;//员工ID
	private Integer setmealId;//套餐ID
	private String cost;//套餐费用
	private Integer medicalId;//状态ID
	private Integer billId;//账单ID
	
	public PersonalBean() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Integer personalId) {
		this.personalId = personalId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getSetmealId() {
		return setmealId;
	}

	public void setSetmealId(Integer setmealId) {
		this.setmealId = setmealId;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Integer getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(Integer medicalId) {
		this.medicalId = medicalId;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	@Override
	public String toString() {
		return "personalBean [personalId=" + personalId + ", companyId=" + companyId + ", staffId=" + staffId
				+ ", setmealId=" + setmealId + ", cost=" + cost + ", medicalId=" + medicalId + ", billId=" + billId
				+ "]";
	}
	
	
}
