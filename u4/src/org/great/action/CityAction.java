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

	private List<City> cities; // ���г���
	//private List<String> travelCities;// ���еĳ���
	private Customer customer;
	
	private String Sproperty;//����չʾs:property��ǩ 
	
	
	private Map<String, String> map=new HashMap<String, String>();

	public String execute() {
		CityDAO cityDao = new CityDAO();
		cities = cityDao.findAllCities();
		List<String> travelCities = new ArrayList<String>();
		travelCities.add("shanghai");//������Դkey��Ӧ
		travelCities.add("diaoyudao");
		//ģ��dao���ҿͻ�
		customer = new Customer(travelCities,"show object property");
		Sproperty="show s:property";
		
		map.put("shanhai", "�Ϻ�");
		map.put("beijing", "����");
		
		
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
