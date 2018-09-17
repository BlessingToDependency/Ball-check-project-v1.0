package org.great.test;


import java.util.List;

import org.great.entity.Dept;
import org.great.mapper.DeptMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDeptMapper {
	@Test
	public void testFindAll() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DeptMapper mapper = ac.getBean("deptMapper", DeptMapper.class);
		
		List<Dept> list = mapper.findAll();
		for (Dept dept : list) {
			System.out.println(dept.getDeptno() + " " + dept.getDname() + " "
					+ dept.getLoc());
		}
	}
	
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DeptMapper mapper = ac.getBean("deptMapper", DeptMapper.class);
		List<Dept> list = mapper.findAll();
		for (Dept dept : list) {
			System.out.println(dept.getDeptno() + " " + dept.getDname() + " "
					+ dept.getLoc());
		}
		
	}

}
