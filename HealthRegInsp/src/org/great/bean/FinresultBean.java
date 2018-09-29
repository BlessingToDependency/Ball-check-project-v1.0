package org.great.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * 检查细项结果表
 * 
 */
@Component
public class FinresultBean {
      private String guChId;//导检单ID
      private int  termId;//细项ID
      private String termVal;//细项值
      private int itemId;//项目ID
      
      @Resource
      private TermBean termBean;//细项实体
      
      public FinresultBean() {
    	  
      }

	public FinresultBean(String guChId, int termId, String termVal, int itemId, TermBean termBean) {
		super();
		this.guChId = guChId;
		this.termId = termId;
		this.termVal = termVal;
		this.itemId = itemId;
		this.termBean = termBean;
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

	public String getTermVal() {
		return termVal;
	}

	public void setTermVal(String termVal) {
		this.termVal = termVal;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public TermBean getTermBean() {
		return termBean;
	}

	public void setTermBean(TermBean termBean) {
		this.termBean = termBean;
	}

	
}
