package org.great.bean;

/*
 * 项目表
 * 
 */

public class LitemBean {
     private int itemId;//项目ID
     private String item;//项目
     private int price;//单价
     private String introd;//简介
     
     public LitemBean(){
    	 
     }
     
	public LitemBean(int itemId, String item, int price, String introd) {
		super();
		this.itemId = itemId;
		this.item = item;
		this.price = price;
		this.introd = introd;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIntrod() {
		return introd;
	}
	public void setIntrod(String introd) {
		this.introd = introd;
	}
     
     
     
     
     
}
