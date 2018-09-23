package org.great.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * 套餐表
 * 
 */
@Component
public class SetmealBean {
    private int setmealId;//套餐ID
    private String setmeal;//套餐
    private double discount;//优惠折扣
    private  int salsvolume;//销量
    private String picture;//图片
    private  int countAll;//套餐价格
    
    @Resource
    private SetcomBean setcomBean;//关联表
//    private LitemBean litemBean;
    private ArrayList<LitemBean> litemBean;//项目表
    
    public SetmealBean(){
    	super();
    }
    
	public SetmealBean(int setmealId, String setmeal, int discount, int salsvolume) {
		super();
		this.setmealId = setmealId;
		this.setmeal = setmeal;
		this.discount = discount;
		this.salsvolume = salsvolume;
	}
	
	public int getSetmealId() {
		return setmealId;
	}
	public void setSetmealId(int setmealId) {
		this.setmealId = setmealId;
	}
	public String getSetmeal() {
		return setmeal;
	}
	public void setSetmeal(String setmeal) {
		this.setmeal = setmeal;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getSalsvolume() {
		return salsvolume;
	}
	public void setSalsvolume(int salsvolume) {
		this.salsvolume = salsvolume;
	}




	public ArrayList<LitemBean> getLitemBean() {
		return litemBean;
	}

	public void setLitemBean(ArrayList<LitemBean> litemBean) {
		this.litemBean = litemBean;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	

	public SetcomBean getSetcomBean() {
		return setcomBean;
	}

	public void setSetcomBean(SetcomBean setcomBean) {
		this.setcomBean = setcomBean;
	}

	
	
	public int getCountAll() {
		return countAll;
	}

	public void setCountAll(int countAll) {
		this.countAll = countAll;
	}

	@Override
	public String toString() {
		return "SetmealBean [setmealId=" + setmealId + ", setmeal=" + setmeal + ", discount=" + discount
				+ ", salsvolume=" + salsvolume + ", picture=" + picture + ", countAll=" + countAll + ", setcomBean="
				+ setcomBean + ", litemBean=" + litemBean + "]";
	}

	
    
    
}
