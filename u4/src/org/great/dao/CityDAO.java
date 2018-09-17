package org.great.dao;

import java.util.ArrayList;
import java.util.List;

import org.great.entity.City;

public class CityDAO {

	/**
	 * 模拟查询所有的城市
	 */
	public List<City> findAllCities() {
		List<City> cities = new ArrayList<City>();
		City c1 = new City("beijing", "北京");
		City c2 = new City("shanghai", "上海");
		City c3 = new City("guangzhou", "广州");
		City c4 = new City("shenzhen", "深圳");
		City c5 = new City("chongqing", "重庆");
		City c6 = new City("diaoyudao", "钓鱼岛");
		cities.add(c1);
		cities.add(c2);
		cities.add(c3);
		cities.add(c4);
		cities.add(c5);
		cities.add(c6);
		return cities;
	}

}
