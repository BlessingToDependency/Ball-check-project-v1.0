package org.great.bean;

import org.springframework.stereotype.Component;

/*
 * 项目关系表
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
