package org.great.search;

import org.springframework.stereotype.Component;

/*
 *     管理员管理模糊搜索条件实体
 */
public class AdminCon { 
	private String adminName;     //管理员名
	private int stateId;          //用户状态ID
	private int statrRn;          //起始
	private int endRn;            //结束
	
	public AdminCon() {
		
	}

	public AdminCon(String adminName, int stateId, int statrRn, int endRn) {
		super();
		this.adminName = adminName;
		this.stateId = stateId;
		this.statrRn = statrRn;
		this.endRn = endRn;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getStatrRn() {
		return statrRn;
	}

	public void setStatrRn(int statrRn) {
		this.statrRn = statrRn;
	}

	public int getEndRn() {
		return endRn;
	}

	public void setEndRn(int endRn) {
		this.endRn = endRn;
	}


}
