package org.great.bean;

import org.springframework.stereotype.Component;

/*
 * 购物车
 */
@Component
public class ShoppingCartBean {

	private Integer cartId;//购物车id
	private Integer companyId;//公司id
	private Integer setmealId;//套餐id
	private Integer cartNumber;//数量
	public ShoppingCartBean() {
		super();
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getSetmealId() {
		return setmealId;
	}
	public void setSetmealId(Integer setmealId) {
		this.setmealId = setmealId;
	}
	public Integer getCartNumber() {
		return cartNumber;
	}
	public void setCartNumber(Integer cartNumber) {
		this.cartNumber = cartNumber;
	}
	
	
}
