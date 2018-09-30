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

      private String termVal;////细项值

      private int itemId;//项目ID
      
      @Resource
      private TermBean termBean;//细项实体
      
      public FinresultBean() {
    	  
      }

      
      
	
	/** 
	 * @Title:FinresultBean
	 * @Description:TODO 
	 * @param guChId
	 * @param termId
	 * @param termVal
	 * @param itemId 
	 */ 




	public FinresultBean(String guChId, int termId, String termVal, int itemId, TermBean termBean) {


		super();
		this.guChId = guChId;
		this.termId = termId;
		this.termVal = termVal;
		this.itemId = itemId;
		this.termBean = termBean;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FinresultBean [guChId=" + guChId + ", termId=" + termId + ", termVal=" + termVal + ", itemId=" + itemId
				+ "]";
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




	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}




	/**
	 * @return the termVal
	 */
	public String getTermVal() {
		return termVal;
	}



	/**
	 * @param termVal the termVal to set
	 */
	public void setTermVal(String termVal) {
		this.termVal = termVal;
	}
      
      
          

	public TermBean getTermBean() {
		return termBean;
	}

	public void setTermBean(TermBean termBean) {
		this.termBean = termBean;
	}


}
