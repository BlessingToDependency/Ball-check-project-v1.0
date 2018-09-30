
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
    
    private StaffBean staffBean;  //员工表
    private Integer currentPage;  //当前页数
    
    
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

	/**
	 * @return the staffBean
	 */
	public StaffBean getStaffBean() {
		return staffBean;
	}

	/**
	 * @param staffBean the staffBean to set
	 */
	public void setStaffBean(StaffBean staffBean) {
		this.staffBean = staffBean;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;

	}
    
    
    
}



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
    
    private StaffBean staffBean;  //员工表
    private Integer currentPage;  //当前页数
    private int perInspId;//人员导检ID
    
    public PerguirelaBean() {
    	
    }
    
    public PerguirelaBean(int staffId, String partYear, int companyId, int batchNum, int perInspId) {
		super();
		this.staffId = staffId;
		this.partYear = partYear;
		this.companyId = companyId;
		this.batchNum = batchNum;
		this.perInspId = perInspId;
	}
	
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PerguirelaBean [staffId=" + staffId + ", partYear=" + partYear + ", companyId=" + companyId
				+ ", batchNum=" + batchNum + ", staffBean=" + staffBean + ", currentPage=" + currentPage + "]";
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

	/**
	 * @return the staffBean
	 */
	public StaffBean getStaffBean() {
		return staffBean;
	}

	/**
	 * @param staffBean the staffBean to set
	 */
	public void setStaffBean(StaffBean staffBean) {
		this.staffBean = staffBean;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the perInspId
	 */
	public int getPerInspId() {
		return perInspId;
	}

	/**
	 * @param perInspId the perInspId to set
	 */
	public void setPerInspId(int perInspId) {
		this.perInspId = perInspId;
	}
    
    
    
}

