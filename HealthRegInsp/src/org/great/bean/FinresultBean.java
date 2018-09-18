package org.great.bean;

/*
 * 检查细项结果表
 * 
 */

public class FinresultBean {
      private String guChId;//导检单ID
      private int  termId;//细项ID
      private int termVal;////细项值
      private int itemId;//项目ID
      
      public FinresultBean() {
    	  
      }
      
      
	public FinresultBean(String guChId, int termId, int termVal, int itemId) {
		super();
		this.guChId = guChId;
		this.termId = termId;
		this.termVal = termVal;
		this.itemId = itemId;
	}
	public String getGuChId() {
		return guChId;
	}
	public void setGuChId(String guChId) {
		this.guChId = guChId;
	}
	public int getTermId() {
		return termId;
	}
	public void setTermId(int termId) {
		this.termId = termId;
	}
	public int getTermVal() {
		return termVal;
	}
	public void setTermVal(int termVal) {
		this.termVal = termVal;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
      
      
      
      
      
}
