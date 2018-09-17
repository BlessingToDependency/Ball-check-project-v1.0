package org.great;

public class Userinfo {

	private String userid;
	private String truename;
	private String loginname;
	private String pwd;
	private String state;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "userid="+userid+"----"+"truename="+truename+"----"+"loginname="+loginname+"----"+"pwd="+pwd+"----"+"state="+state;
	}
}
