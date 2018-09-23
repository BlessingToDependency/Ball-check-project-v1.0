package org.great.bean;

import org.springframework.stereotype.Component;

/*
 * 项目表
 * 
 */
@Component
public class LitemBean {
     private int itemId;//项目ID
     private String item;//项目
     private int price;//单价
     private String introd;//简介
     
     public LitemBean(){
    	 super();
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



	@Override
	public String toString() {
		return "LitemBean [itemId=" + itemId + ", item=" + item + ", price=" + price + ", introd=" + introd + "]";
	}
     
     
     
     
     
}
