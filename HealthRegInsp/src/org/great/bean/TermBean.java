package org.great.bean;

/*
 * 细项
 * 
 */

public class TermBean {
     private  int termId;//细项ID
     private  String term;//细项
     private String measur;//计量单位
     private int upLimit;//上限值
     private int downLimit;//下限值
     
     public  TermBean() {
    	 
     }
     
	public TermBean(int termId, String term, String measur, int upLimit, int downLimit) {
		super();
		this.termId = termId;
		this.term = term;
		this.measur = measur;
		this.upLimit = upLimit;
		this.downLimit = downLimit;
	}
	
	
	public int getTermId() {
		return termId;
	}
	public void setTermId(int termId) {
		this.termId = termId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getMeasur() {
		return measur;
	}
	public void setMeasur(String measur) {
		this.measur = measur;
	}
	public int getUpLimit() {
		return upLimit;
	}
	public void setUpLimit(int upLimit) {
		this.upLimit = upLimit;
	}
	public int getDownLimit() {
		return downLimit;
	}
	public void setDownLimit(int downLimit) {
		this.downLimit = downLimit;
	}
     
     
     
}
