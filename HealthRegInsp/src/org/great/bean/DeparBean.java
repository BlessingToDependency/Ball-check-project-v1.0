package org.great.bean;

/*
 * 科室表
 * 
 */
public class DeparBean {
    private int depaId;//科室ID
    private String depa;//科室
    
    public  DeparBean() {
    	
    }
    
    
	public DeparBean(int depaId, String depa) {
		super();
		this.depaId = depaId;
		this.depa = depa;
	}
	
	public int getDepaId() {
		return depaId;
	}
	public void setDepaId(int depaId) {
		this.depaId = depaId;
	}
	public String getDepa() {
		return depa;
	}
	public void setDepa(String depa) {
		this.depa = depa;
	}
    
    
    
    
    
}
