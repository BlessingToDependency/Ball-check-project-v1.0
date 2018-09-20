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
    private String proposal;//总结和建议
    private String lifeGuid;//生活保健指导
    
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
    
    
    
}
