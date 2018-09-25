package org.great.bean;

import org.springframework.stereotype.Component;

/*
 * 套餐项目组合表
 */
@Component
public class SetcomBean {
	private int setmealId;//套餐ID
	private int itemId;//项目ID
	
	
	public SetcomBean() {
		super();
	}
	public int getSetmealId() {
		return setmealId;
	}
	public void setSetmealId(int setmealId) {
		this.setmealId = setmealId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	
	
}
