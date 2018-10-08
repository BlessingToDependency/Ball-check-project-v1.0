package org.great.bean;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * 日志表
 * 
 */
@Component
public class LogBean implements Serializable{
    private int logId;//日志ID
    private String time;//操作时间
    private String name;//操作人
    private String matter;//操作事项
    private String module;//操做模块
    private String commite;//执行描述
    private String method;//执行的方法
    private String  ip;   //IP地址
    private String   responseTime;  //响应时间
    private Short state;   //该操作状态， -1表示失败
   
    private String start;
    private String end;
    
    
    public LogBean() {
    	
    }
    
    
	public LogBean(int logId, String time, String name, String matter,String start,String end,String module,String commite,String method) {
		super();
		this.logId = logId;
		this.time = time;
		this.name = name;
		this.matter = matter;
		this.start=start;
		this.end=end;
		this.module=module;
		this.commite=commite;
		this.method=method;
	}
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LogBean [logId=" + logId + ", time=" + time + ", name=" + name + ", matter=" + matter + ", module="
				+ module + ", commite=" + commite + ", method=" + method + ", start=" + start + ", end=" + end + "]";
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


	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
	}


	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
	}


	public String getCommite() {
		return commite;
	}


	public void setCommite(String commite) {
		this.commite = commite;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}


	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}


	/**
	 * @return the responseTime
	 */
	public String getResponseTime() {
		return responseTime;
	}


	/**
	 * @param responseTime the responseTime to set
	 */
	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}


	/**
	 * @return the state
	 */
	public Short getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(Short state) {
		this.state = state;
	}
    
    
    
    
    
}
