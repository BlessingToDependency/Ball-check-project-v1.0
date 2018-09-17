package com.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	
	private String fname;

	
	public InputStream getDownloadFile()
	{
		
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/a.ppt");
	}
	
	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}

	public String getFname() {
		return "a.ppt";
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
}
