package org.great.bean;
/*
 * 人员套餐关系表
 */
public class StaffMealBean {
	private int staffId;//人员ID

	private int setmealId;//套餐ID

	
	
	
	
	public StaffMealBean() {
		super();
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getSetmealId() {
		return setmealId;
	}
	public void setSetmealId(int setmealId) {
		this.setmealId = setmealId;
	}
	@Override
	public String toString() {
		return "StaffMealBean [staffId=" + staffId + ", setmealId=" + setmealId + "]";
	}
	
	
	
}
