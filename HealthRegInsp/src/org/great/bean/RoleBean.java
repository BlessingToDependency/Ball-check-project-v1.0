package org.great.bean;

import org.springframework.stereotype.Component;

/*
 * 角色表
 */
@Component
public class RoleBean {
	private int roleId;//角色ID
	private String role;//角色
	
	
	
	public RoleBean() {
		super();
	}



	public RoleBean(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}



	public int getRoleId() {
		return roleId;
	}



	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "RoleBean [roleId=" + roleId + ", role=" + role + "]";
	}
	
	
	
}
