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
     private FinresultBean finresultBean; //检查细项结果表
     private SmallBean  smallBean; //小结记录表
     
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
				+ ", tblSetCom=" + tblSetCom + ", finresultBean=" + finresultBean + ", smallBean=" + smallBean + "]";
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

	/**
	 * @return the finresultBean
	 */
	public FinresultBean getFinresultBean() {
		return finresultBean;
	}

	/**
	 * @param finresultBean the finresultBean to set
	 */
	public void setFinresultBean(FinresultBean finresultBean) {
		this.finresultBean = finresultBean;
	}

	/**
	 * @return the smallBean
	 */
	public SmallBean getSmallBean() {
		return smallBean;
	}

	/**
	 * @param smallBean the smallBean to set
	 */
	public void setSmallBean(SmallBean smallBean) {
		this.smallBean = smallBean;
	}
     
     
     
     
     
}
