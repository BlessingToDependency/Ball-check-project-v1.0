package org.great.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.great.entity.Dept;
import org.great.entity.Dept2;
import org.great.mapper.DeptMapper;
import org.great.mapper.DeptMapper2;
import org.great.tools.MyBatisUtil;
import org.junit.Test;

public class TestCRUD {

	//@Test
	public void testAdd() throws IOException {
		SqlSession session = MyBatisUtil.getSession();
		Dept dept = new Dept();
		dept.setDeptno(40212);
		dept.setDname("����");
		dept.setLoc("����"); 
		//session.insert("addDept",dept);
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		int i=mapper.addDept(dept);
		
		System.out.println(i+"----------"+dept.getDeptno());
		session.commit();
		session.close();
	}
	//@Test
	public void testDelete() {
		SqlSession session = MyBatisUtil.getSession();
		//session.delete("deleteById",40);
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		mapper.deleteById(40);
		session.close();

	}
	//@Test
	public void testFindById() {
		SqlSession session = MyBatisUtil.getSession();
	//	Dept dept=session.selectOne("findById",10);
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		Dept dept=mapper.findById(10);
		System.out.println(dept);
		session.close();
	}
	
	//@Test
	public void testUpdateById(){
		SqlSession session = MyBatisUtil.getSession();
		Dept dept=session.selectOne("findById",30);
		//�޸�
		dept.setDname("�˹ܲ�");
		dept.setLoc("�Ϻ�");
		//session.update("updateDept", dept);
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		mapper.updateDept(dept);
		session.commit();
		session.close();
	}
	
	@Test
	public void testfindAll() {
		SqlSession session = MyBatisUtil.getSession();
		//List<Dept>depts=session.selectList("findAll");
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		List<Dept>depts=mapper.findAll();
		for (Dept dept : depts) {
			System.out.println(dept);
		}
	}
	//resultMap
	@Test
	public void testResultMap() {
		SqlSession session = MyBatisUtil.getSession();
		DeptMapper2 mapper2 = session.getMapper(DeptMapper2.class);
		List<Dept2> d2=mapper2.findAll();
		for (Dept2 dept2 : d2) {
			System.out.println(dept2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		TestCRUD  testCRUD=new TestCRUD();
		testCRUD.testAdd();
//		testCRUD.testResultMap();
	}

}
