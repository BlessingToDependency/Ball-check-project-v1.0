package org.great.bean;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/*
 * 购物车
 */
@Component
public class ShoppingCartBean {

	private Integer cartId;//购物车id
	private Integer companyId;//公司id
	private Integer setmealId;//套餐id
	private Integer acrtNumber;//数量
	private ArrayList<SetmealBean> setmealBean;//套餐表
	
	
	 private String setmeal;//套餐
	 private String picture;//图片
	 private  int countAll;//套餐价格
	 private double discount;//优惠折扣
	
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

	public Integer getAcrtNumber() {
		return acrtNumber;
	}
	public void setAcrtNumber(Integer acrtNumber) {
		this.acrtNumber = acrtNumber;
	}
	public ArrayList<SetmealBean> getSetmealBean() {
		return setmealBean;
	}
	public void setSetmealBean(ArrayList<SetmealBean> setmealBean) {
		this.setmealBean = setmealBean;
	}
	public String getSetmeal() {
		return setmeal;
	}
	public void setSetmeal(String setmeal) {
		this.setmeal = setmeal;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getCountAll() {
		return countAll;
	}
	public void setCountAll(int countAll) {
		this.countAll = countAll;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
}
