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
     private FinresultBean finresultBean; //检查细项结果表
     private SmallBean  smallBean; //小结记录表
     private LitemBean litemBean;  //细项结果表
     
     public  TermBean() {
    	 
     }
     
     /* (non-Javadoc)
 	 * @see java.lang.Object#toString()
 	 */
 	@Override
 	public String toString() {
 		return "TermBean [termId=" + termId + ", term=" + term + ", measur=" + measur + ", upLimit=" + upLimit
 				+ ", downLimit=" + downLimit + ", none=" + none + ", itemComBean=" + itemComBean + ", finresultBean="
 				+ finresultBean + ", smallBean=" + smallBean + ", litemBean=" + litemBean + "]";
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
	/**
	 * @return the litemBean
	 */
	public LitemBean getLitemBean() {
		return litemBean;
	}
	/**
	 * @param litemBean the litemBean to set
	 */
	public void setLitemBean(LitemBean litemBean) {
		this.litemBean = litemBean;
	}
	
     
     
     
}
