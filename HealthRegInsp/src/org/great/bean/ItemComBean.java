package org.great.bean;

import org.springframework.stereotype.Component;


/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 项目细项关系实体类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-24 20:33 
*/ 
@Component
public class ItemComBean {

	private Integer itemId;//项目id
	private Integer termId;//细项id
	
	public ItemComBean() {
		// TODO Auto-generated constructor stub
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	@Override
	public String toString() {
		return "ItemCom [itemId=" + itemId + ", termId=" + termId + "]";
	}
	
}
