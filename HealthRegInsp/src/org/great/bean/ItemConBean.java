/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.bean 
 * @author: wjx(wangj)   
 * @date: 2018年9月25日 下午5:37:29 
 */
package org.great.bean;

import org.springframework.stereotype.Component;

/** 
 * @ClassName: ItemConBean 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年9月25日 下午5:37:29  
 */
@Component
public class ItemConBean {

	private Integer currentPage;  //当前页数
	private Integer maxPrice ;  //最高价格
	private Integer minPrice;  //最低价格	
	private  Integer pagecout = 5; //每页限制个数

	
	/** 
	 * @Title:ItemConBean
	 * @Description:TODO  
	 */
	public ItemConBean() {
		// TODO Auto-generated constructor stub
	}
	
		
	/** 
	 * @Title:ItemConBean
	 * @Description:TODO 
	 * @param currentPage
	 * @param maxPrice
	 * @param minPrice 
	 */ 
	public ItemConBean(Integer currentPage, Integer maxPrice, Integer minPrice) {
		super();
		this.currentPage = currentPage;
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemConBean [currentPage=" + currentPage + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice + "]";
	}





	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}





	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}





	/**
	 * @return the maxPrice
	 */
	public Integer getMaxPrice() {
		return maxPrice;
	}





	/**
	 * @param maxPrice the maxPrice to set
	 */
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}





	/**
	 * @return the minPrice
	 */
	public Integer getMinPrice() {
		return minPrice;
	}





	/**
	 * @param minPrice the minPrice to set
	 */
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}


	/**
	 * @return the pagecout
	 */
	public Integer getPagecout() {
		return pagecout;
	}


	/**
	 * @param pagecout the pagecout to set
	 */
	public void setPagecout(Integer pagecout) {
		this.pagecout = pagecout;
	}



	
	
	
}
