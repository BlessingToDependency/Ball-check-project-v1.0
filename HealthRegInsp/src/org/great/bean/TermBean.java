package org.great.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * 细项
 * 
 */

@Component
public class TermBean {
     private  int termId;//细项ID
     private  String term;//细项
     private String measur;//计量单位
     private String upLimit;//上限值
     private String downLimit;//下限值
     @Resource
     private ItemComBean itemComBean;//项目细项关系Bean
     public  TermBean() {
    	 
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
	public String getUpLimit() {
		return upLimit;
	}
	public void setUpLimit(String upLimit) {
		this.upLimit = upLimit;
	}
	public String getDownLimit() {
		return downLimit;
	}
	public void setDownLimit(String downLimit) {
		this.downLimit = downLimit;
	}
	@Override
	public String toString() {
		return "TermBean [termId=" + termId + ", term=" + term + ", measur=" + measur + ", upLimit=" + upLimit
				+ ", downLimit=" + downLimit + ", itemComBean=" + itemComBean + "]";
	}
     
     
     
}
