/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.bean 
 * @author: wjx(wangj)   
 * @date: 2018年9月21日 下午11:03:30 
 */
package org.great.bean;

import java.awt.event.ItemEvent;

import org.springframework.stereotype.Component;

/** 
 * @ClassName: Setcom 
 * @Description:套餐项目组合表
 * @author: wjx(wangj)  
 * @date: 2018年9月21日 下午11:03:30  
 */
@Component
public class TblSetCom {

	private Integer comId;  //套餐项目组合Id
	private Integer itemID;	//项目ID
	private Integer  setmealId; //套餐Id
	
	
	/** 
	 * @Title:TblSetCom
	 * @Description:TODO  
	 */
	public TblSetCom() {
		// TODO Auto-generated constructor stub
	}
	


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TblSetCom [comId=" + comId + ", itemID=" + itemID + ", setmealId=" + setmealId + "]";
	}





	/** 
	 * @Title:TblSetCom
	 * @Description:TODO 
	 * @param comId
	 * @param itemID
	 * @param setmealId 
	 */ 
	public TblSetCom(Integer comId, Integer itemID, Integer setmealId) {
		super();
		this.comId = comId;
		this.itemID = itemID;
		this.setmealId = setmealId;
	}

	/**
	 * @return the comId
	 */
	public Integer getComId() {
		return comId;
	}
	/**
	 * @param comId the comId to set
	 */
	public void setComId(Integer comId) {
		this.comId = comId;
	}
	/**
	 * @return the itemID
	 */
	public Integer getItemID() {
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}
	/**
	 * @return the setmealId
	 */
	public Integer getSetmealId() {
		return setmealId;
	}
	/**
	 * @param setmealId the setmealId to set
	 */
	public void setSetmealId(Integer setmealId) {
		this.setmealId = setmealId;
	}
	
	
	
	
}
