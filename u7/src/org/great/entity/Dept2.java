package org.great.entity;

public class Dept2 {
	private Integer id;
	private String name;
	private String where;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	@Override
	public String toString() {
		return "Dept2 [id=" + id + ", name=" + name + ", where=" + where + "]";
	}
	
	
	
	

}
