package org.great.bean;
/*
 * 人员套餐关系表
 */
public class StaffMealBean {
	private int setmealId;//套餐ID
	private int perInspId;//人员导检ID:主键
	
	  private double countDisAll;//套餐折算后价格
	
	 private int staffId;//人员ID
	

	

	public double getCountDisAll() {
		return countDisAll;
	}

	public void setCountDisAll(double countDisAll) {
		this.countDisAll = countDisAll;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

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
