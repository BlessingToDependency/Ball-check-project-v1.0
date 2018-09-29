package org.great.bean;

import org.springframework.stereotype.Component;

/*
 * 日志表
 * 
 */
@Component
public class LogBean {
    private int logId;//日志ID
    private String time;//操作时间
    private String name;//操作人
    private String matter;//操作事项
    
    
    public LogBean() {
    	
    }
    
    
	public LogBean(int logId, String time, String name, String matter) {
		super();
		this.logId = logId;
		this.time = time;
		this.name = name;
		this.matter = matter;
	}
	
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMatter() {
		return matter;
	}
	public void setMatter(String matter) {
		this.matter = matter;
	}
    
    
    
    
    
}
