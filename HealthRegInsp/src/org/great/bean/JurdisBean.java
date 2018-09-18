package org.great.bean;

/*
 * 权限分配表
 * 
 */
public class JurdisBean {
      private int jurisId;//权限ID
      private String menu;//菜单模块
      private int parId;//父级ID
      
     public  JurdisBean(){
    	 
     }
      
      
	public JurdisBean(int jurisId, String menu, int parId) {
		super();
		this.jurisId = jurisId;
		this.menu = menu;
		this.parId = parId;
	}
	
	public int getJurisId() {
		return jurisId;
	}
	public void setJurisId(int jurisId) {
		this.jurisId = jurisId;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getParId() {
		return parId;
	}
	public void setParId(int parId) {
		this.parId = parId;
	}
      
      
}
