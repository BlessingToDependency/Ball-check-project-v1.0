package org.great.entity;

import java.util.List;

public class Customer {
	
	private String cname;
	
	private List<String> travelCities;//要旅游的城市
	
	
	public String test(){
		
		return "abc";
	}

	public List<String> getTravelCities() {
		return travelCities;
	}

	public void setTravelCities(List<String> travelCities) {
		this.travelCities = travelCities;
	}
	

	public Customer(List<String> travelCities,String cname) {
		super();
		this.travelCities = travelCities;
		this.cname=cname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	

}
