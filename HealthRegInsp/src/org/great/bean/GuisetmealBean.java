package org.great.bean;

import org.springframework.stereotype.Component;

/*
 * 导检单套餐表
 */
@Component
public class GuisetmealBean {
	private String guChId;//导检单ID	==条码号
	private int setmealId;//套餐ID
	
	
	public GuisetmealBean() {
		super();
	}
	public String getGuChId() {
		return guChId;
	}
	public void setGuChId(String guChId) {
		this.guChId = guChId;
	}
	public int getSetmealId() {
		return setmealId;
	}
	public void setSetmealId(int setmealId) {
		this.setmealId = setmealId;
	}
	
	

}
