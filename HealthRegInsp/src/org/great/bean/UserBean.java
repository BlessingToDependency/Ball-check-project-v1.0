package org.great.bean;

import org.springframework.stereotype.Component;

/*
 * 前台登陆表
 */
@Component
public class UserBean {
	private int companyId;//公司ID
	private String company;//公司名称
	private String pwd;//密码
	private String address;	//企业地址
	private String contacts;//联系人
	private long phone;//电话
	private int balance;	//余额
	private String busNum;//工商号
	private String head;//头像这是头像
	private int stateId; //用户状态(启用/禁用)
	private int logicId; //逻辑状态（删除/假删除）
	private int phyExamId; //开单状态
	private String regTime;  //账号注册时间
	
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserBean [companyId=" + companyId + ", company=" + company + ", pwd=" + pwd + ", address=" + address
				+ ", contacts=" + contacts + ", phone=" + phone + ", balance=" + balance + ", busNum=" + busNum
				+ ", head=" + head + ", stateId=" + stateId + ", logicId=" + logicId + ", phyExamId=" + phyExamId
				+ ", regTime=" + regTime + "]";
	}
	public UserBean() {
		super();
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getBusNum() {
		return busNum;
	}
	public void setBusNum(String busNum) {
		this.busNum = busNum;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getLogicId() {
		return logicId;
	}
	public void setLogicId(int logicId) {
		this.logicId = logicId;
	}
	public int getPhyExamId() {
		return phyExamId;
	}
	public void setPhyExamId(int phyExamId) {
		this.phyExamId = phyExamId;
	}
	/**
	 * @return the regTime
	 */
	public String getRegTime() {
		return regTime;
	}
	/**
	 * @param regTime the regTime to set
	 */
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	
	
	
	
}
