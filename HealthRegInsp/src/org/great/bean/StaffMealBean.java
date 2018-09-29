package org.great.bean;
/*
 * 人员套餐关系表
 */
public class StaffMealBean {
	private int setmealId;//套餐ID
	private int perInspId;//人员导检ID:主键

	
	public StaffMealBean() {
		super();
	}

	public int getPerInspId() {
		return perInspId;
	}

	public void setPerInspId(int perInspId) {
		this.perInspId = perInspId;
	}

	
	public int getSetmealId() {
		return setmealId;
	}
	public void setSetmealId(int setmealId) {
		this.setmealId = setmealId;
	}

	@Override
	public String toString() {
		return "StaffMealBean [setmealId=" + setmealId + ", perInspId=" + perInspId + ", getPerInspId()="
				+ getPerInspId() + ", getSetmealId()=" + getSetmealId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
