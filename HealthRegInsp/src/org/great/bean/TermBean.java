package org.great.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 细项实体类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-24 20:32 
*/ 
@Component
public class TermBean {
     private Integer termId;//细项ID
     private String term;//细项
     private String measur;//计量单位
     private String upLimit;//上限值
     private String downLimit;//下限值
     private String none;//参考值
     @Resource
     private ItemComBean itemComBean;//项目细项关系Bean
     public  TermBean() {
    	 
     }
	public Integer getTermId() {
		return termId;
	}
	public void setTermId(Integer termId) {
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
	public String getNone() {
		return none;
	}
	public void setNone(String none) {
		this.none = none;
	}
	@Override
	public String toString() {
		return "TermBean [termId=" + termId + ", term=" + term + ", measur=" + measur + ", upLimit=" + upLimit
				+ ", downLimit=" + downLimit + ", none=" + none + ", itemComBean=" + itemComBean + "]";
	}
	
     
     
     
}
