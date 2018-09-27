package org.great.search;

/*
 *     公司批次人员信息模糊搜索条件实体
 */
public class BatchSheetCon {
	private int companyId;//公司ID
	private String partYear;//年份
	private int batch;    //批次号
	private String staffName;//员工名
	private int statrRn;     //起始
	private int endRn;       //结束
	
	public BatchSheetCon() {
		
	}

	public BatchSheetCon(int companyId, String partYear, int batch, String staffName, int statrRn, int endRn) {
		super();
		this.companyId = companyId;
		this.partYear = partYear;
		this.batch = batch;
		this.staffName = staffName;
		this.statrRn = statrRn;
		this.endRn = endRn;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getPartYear() {
		return partYear;
	}

	public void setPartYear(String partYear) {
		this.partYear = partYear;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
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
