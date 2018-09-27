package org.great.search;

/*
 *     团检开单模糊搜索条件实体
 */
public class CompanyCon {
	private String company;        //公司名称
	private int statrRn;          //起始
	private int endRn;            //结束
	
	
	public CompanyCon() {
		
	}
	public CompanyCon(String company, int statrRn, int endRn) {
		super();
		this.company = company;
		this.statrRn = statrRn;
		this.endRn = endRn;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getStatrRn() {
		return statrRn;
	}
	public void setStatrRn(int statrRn) {
		this.statrRn = statrRn;
	}
	public int getEndRn() {
		return endRn;
	}
	public void setEndRn(int endRn) {
		this.endRn = endRn;
	}

}
