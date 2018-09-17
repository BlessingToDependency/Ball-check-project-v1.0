package org.great.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.great.dao.CityDAO;
import org.great.entity.City;
import org.great.entity.Customer;

public class CityAction {

	private List<City> cities; // 所有城市
	//private List<String> travelCities;// 旅行的城市
	private Customer customer;
	
	private String Sproperty;//用于展示s:property标签 
	
	
	private Map<String, String> map=new HashMap<String, String>();

	public String execute() {
		CityDAO cityDao = new CityDAO();
		cities = cityDao.findAllCities();
		List<String> travelCities = new ArrayList<String>();
		travelCities.add("shanghai");//与数据源key对应
		travelCities.add("diaoyudao");
		//模拟dao查找客户
		customer = new Customer(travelCities,"show object property");
		Sproperty="show s:property";
		
		map.put("shanhai", "上海");
		map.put("beijing", "北京");
		
		
		return "success";
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getSproperty() {
		return Sproperty;
	}

	public void setSproperty(String sproperty) {
		Sproperty = sproperty;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}



}
