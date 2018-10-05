/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.search 
 * @author: wjx(wangj)   
 * @date: 2018年10月4日 上午11:08:28 
 */
package org.great.bean;

import javax.annotation.Resource;

/** 
 * @ClassName: TblChannel 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年10月4日 上午11:08:28  
 */
@Resource
public class TblChannel {

	private  Integer  orderCount;  //套餐数量
	private  String   orderName ;  //套餐名字
	private  String   before;    //开始时间
	private   String  after ;    //结束时间
	
	
	/** 
	 * @Title:TblChannel
	 * @Description:TODO  
	 */
	public TblChannel() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TblChannel [orderCount=" + orderCount + ", orderName=" + orderName + ", before=" + before + ", after="
				+ after + "]";
	}




	/**
	 * @return the orderCount
	 */
	public Integer getOrderCount() {
		return orderCount;
	}
	/**
	 * @param orderCount the orderCount to set
	 */
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	/**
	 * @return the orderName
	 */
	public String getOrderName() {
		return orderName;
	}
	/**
	 * @param orderName the orderName to set
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	/**
	 * @return the before
	 */
	public String getBefore() {
		return before;
	}
	/**
	 * @param before the before to set
	 */
	public void setBefore(String before) {
		this.before = before;
	}
	/**
	 * @return the after
	 */
	public String getAfter() {
		return after;
	}
	/**
	 * @param after the after to set
	 */
	public void setAfter(String after) {
		this.after = after;
	}
	
	
	
	
	
}
