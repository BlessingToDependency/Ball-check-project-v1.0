package org.great.dao;

import java.util.ArrayList;
import java.util.List;

import org.great.entity.City;

public class CityDAO {

	/**
	 * ģ���ѯ���еĳ���
	 */
	public List<City> findAllCities() {
		List<City> cities = new ArrayList<City>();
		City c1 = new City("beijing", "����");
		City c2 = new City("shanghai", "�Ϻ�");
		City c3 = new City("guangzhou", "����");
		City c4 = new City("shenzhen", "����");
		City c5 = new City("chongqing", "����");
		City c6 = new City("diaoyudao", "���㵺");
		cities.add(c1);
		cities.add(c2);
		cities.add(c3);
		cities.add(c4);
		cities.add(c5);
		cities.add(c6);
		return cities;
	}

}
