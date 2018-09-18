package org.great.bean;

/*
 * 套餐表
 * 
 */
public class SetmealBean {
    private int setmealId;//套餐ID
    private String setmeal;//套餐
    private int discount;//优惠折扣
    private  int salsvolume;//销量
    
    public SetmealBean(){
    	
    }
    
	public SetmealBean(int setmealId, String setmeal, int discount, int salsvolume) {
		super();
		this.setmealId = setmealId;
		this.setmeal = setmeal;
		this.discount = discount;
		this.salsvolume = salsvolume;
	}
	
	public int getSetmealId() {
		return setmealId;
	}
	public void setSetmealId(int setmealId) {
		this.setmealId = setmealId;
	}
	public String getSetmeal() {
		return setmeal;
	}
	public void setSetmeal(String setmeal) {
		this.setmeal = setmeal;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getSalsvolume() {
		return salsvolume;
	}
	public void setSalsvolume(int salsvolume) {
		this.salsvolume = salsvolume;
	}
    
    
}
