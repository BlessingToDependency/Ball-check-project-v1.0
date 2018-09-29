package org.great.bean;

import org.springframework.stereotype.Component;

/*
 *员工导检单关系表 
 * 
 */
@Component
public class PerguirelaBean {
    private int staffId;//人员ID
    private String partYear;//年份
    private int companyId;//公司ID
    private int batchNum;//批次号
    private int perInspId;//人员导检ID（主键）
    
    
    public PerguirelaBean() {
    	
    }
    
	public PerguirelaBean(int staffId, String partYear, int companyId, int batchNum) {
		super();
		this.staffId = staffId;
		this.partYear = partYear;
		this.companyId = companyId;
		this.batchNum = batchNum;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getPartYear() {
		return partYear;
	}
	public void setPartYear(String partYear) {
		this.partYear = partYear;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(int batchNum) {
		this.batchNum = batchNum;
	}

	public int getPerInspId() {
		return perInspId;
	}

	public void setPerInspId(int perInspId) {
		this.perInspId = perInspId;
	}

	@Override
	public String toString() {
		return "PerguirelaBean [staffId=" + staffId + ", partYear=" + partYear + ", companyId=" + companyId
				+ ", batchNum=" + batchNum + ", perInspId=" + perInspId + "]";
	}
    
    
    
}
