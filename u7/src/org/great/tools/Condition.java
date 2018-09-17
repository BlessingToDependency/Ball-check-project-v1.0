package org.great.tools;

import java.util.List;

public class Condition {
	
	private Integer deptno;
	
	private Boolean isHigh;
	
	private Double salary;
	
	private List<Integer> empnos;
	
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public List<Integer> getEmpnos() {
		return empnos;
	}
	public void setEmpnos(List<Integer> empnos) {
		this.empnos = empnos;
	}
	public Boolean getIsHigh() {
		return isHigh;
	}
	public void setIsHigh(Boolean isHigh) {
		this.isHigh = isHigh;
	}
	

}
