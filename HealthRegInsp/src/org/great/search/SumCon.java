package org.great.search;
/*
 *     小结模糊搜索条件实体
 */
public class SumCon {
	private int depaId;       //项目ID
	private String staffName;  //员工姓名
	private int statrRn;          //起始
	private int endRn;            //结束
	
	public SumCon() {
		
	}

	public SumCon(int depaId, String staffName, int statrRn, int endRn) {
		super();
		this.depaId = depaId;
		this.staffName = staffName;
		this.statrRn = statrRn;
		this.endRn = endRn;
	}

	public int getDepaId() {
		return depaId;
	}

	public void setDepaId(int depaId) {
		this.depaId = depaId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
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
