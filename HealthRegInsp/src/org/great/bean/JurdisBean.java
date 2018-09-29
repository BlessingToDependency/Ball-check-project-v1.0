package org.great.bean;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 权限信息实体类 
* @author: （作者名）LYQ  
* @date: （日期）2018-09-26 22:42 
*/ 
@Component
public class JurdisBean {
	
     private Integer jurisId;//权限ID
     private String menu;//菜单模块
     private Integer parId;//父级ID
     private String url;//url地址
     
     
     public  JurdisBean(){
    	 
     }
      
	public Integer getJurisId() {
		return jurisId;
	}
	public void setJurisId(Integer jurisId) {
		this.jurisId = jurisId;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public Integer getParId() {
		return parId;
	}
	public void setParId(Integer parId) {
		this.parId = parId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

	

	@Override
	public String toString() {
		return "JurdisBean [jurisId=" + jurisId + ", menu=" + menu + ", parId=" + parId + ", url=" + url + "]";
	}
      
      
}
