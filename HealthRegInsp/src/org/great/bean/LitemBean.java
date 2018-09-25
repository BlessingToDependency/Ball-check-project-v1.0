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
     
     private TblSetCom tblSetCom;  //套餐项目关系表
     public LitemBean(){
    	 
     }
     
	public LitemBean(int itemId, String item, int price, String introd) {
		super();
		this.itemId = itemId;
		this.item = item;
		this.price = price;
		this.introd = introd;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LitemBean [itemId=" + itemId + ", item=" + item + ", price=" + price + ", introd=" + introd
				+ ", tblSetCom=" + tblSetCom + "]";
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

	/**
	 * @return the tblSetCom
	 */
	public TblSetCom getTblSetCom() {
		return tblSetCom;
	}

	/**
	 * @param tblSetCom the tblSetCom to set
	 */
	public void setTblSetCom(TblSetCom tblSetCom) {
		this.tblSetCom = tblSetCom;
	}
     
     
     
     
     
}
