package org.great.bean;

import org.springframework.stereotype.Component;

/*
 *总结记录表 
 * 
 */
@Component
public class TotalBean {
    private int totalId;//总结记录ID
    private String guChId;//导检单ID
    private String doctor;//总检医生名
    private String proposal;//总结
    private String suggest; //建议
    private String lifeGuid;//生活保健指导
    private Integer  docSummary; //总结状态
    
    public TotalBean (){
    	
    }
    
	public TotalBean(int totalId, String guChId, String doctor, String proposal, String lifeGuid) {
		super();
		this.totalId = totalId;
		this.guChId = guChId;
		this.doctor = doctor;
		this.proposal = proposal;
		this.lifeGuid = lifeGuid;
	}
	
		
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TotalBean [totalId=" + totalId + ", guChId=" + guChId + ", doctor=" + doctor + ", proposal=" + proposal
				+ ", suggest=" + suggest + ", lifeGuid=" + lifeGuid + ", docSummary=" + docSummary + "]";
	}

	public int getTotalId() {
		return totalId;
	}
	public void setTotalId(int totalId) {
		this.totalId = totalId;
	}
	public String getGuChId() {
		return guChId;
	}
	public void setGuChId(String guChId) {
		this.guChId = guChId;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getProposal() {
		return proposal;
	}
	public void setProposal(String proposal) {
		this.proposal = proposal;
	}
	public String getLifeGuid() {
		return lifeGuid;
	}
	public void setLifeGuid(String lifeGuid) {
		this.lifeGuid = lifeGuid;
	}

	/**
	 * @return the suggest
	 */
	public String getSuggest() {
		return suggest;
	}

	/**
	 * @param suggest the suggest to set
	 */
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	/**
	 * @return the docSummary
	 */
	public Integer getDocSummary() {
		return docSummary;
	}

	/**
	 * @param docSummary the docSummary to set
	 */
	public void setDocSummary(Integer docSummary) {
		this.docSummary = docSummary;
	}
    
    
    
}
