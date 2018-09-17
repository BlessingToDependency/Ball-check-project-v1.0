package org.great.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.great.entity.Emp;
import org.great.mapper.EmpMapper;
import org.great.tools.Condition;
import org.great.tools.MyBatisUtil;
import org.junit.Test;

public class TestEmp {

	// @Test
	public void testFindByDept() {
		SqlSession session = MyBatisUtil.getSession();
		EmpMapper dao = session.getMapper(EmpMapper.class);
		Condition cond = new Condition();
		cond.setDeptno(10000);
		List<Emp> list = dao.findByDept(cond);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " + emp.getEname() + " "
					+ emp.getJob());
		}

	}

	@Test
	public void testFindByisHigh() {
		SqlSession session = MyBatisUtil.getSession();
		EmpMapper dao = session.getMapper(EmpMapper.class);
		Condition cond = new Condition();
		cond.setIsHigh(true);
		List<Emp> list = dao.findBySalary(cond);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " + emp.getEname() + " "
					+ emp.getJob() + " " + emp.getSal());
		}

	}

	// @Test
	public void testfindByDeptAndSalary() {
		SqlSession session = MyBatisUtil.getSession();
		EmpMapper dao = session.getMapper(EmpMapper.class);
		Condition cond = new Condition();
		cond.setSalary(2000.0);
		cond.setDeptno(10);
		List<Emp> list = dao.findByDeptAndSalary(cond);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " + emp.getEname() + " "
					+ emp.getJob() + " " + emp.getSal());
		}

	}

	// @Test
	public void testUpdate() {
		SqlSession session = MyBatisUtil.getSession();
		EmpMapper dao = session.getMapper(EmpMapper.class);
		Emp e = new Emp();
		e.setEmpno(7902);
		// e.setEname("Lilei");
		e.setJob("CXY");
		dao.update(e);
	}

	// @Test
	public void testfindByDeptAndSalary2() {
		SqlSession session = MyBatisUtil.getSession();
		EmpMapper dao = session.getMapper(EmpMapper.class);
		Condition cond = new Condition();
		cond.setSalary(2000.0);
		cond.setDeptno(10);
		List<Emp> list = dao.findByDeptAndSalary2(cond);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " + emp.getEname() + " "
					+ emp.getJob() + " " + emp.getSal());
		}

	}

	// @Test
	public void testUpdate2() {
		SqlSession session = MyBatisUtil.getSession();
		EmpMapper dao = session.getMapper(EmpMapper.class);
		Emp e = new Emp();
		e.setEmpno(7902);
		e.setEname("Levi's");
		e.setJob("CXY");
		dao.update2(e);
	}

	@Test
	public void testfindByIds() {
		SqlSession session = MyBatisUtil.getSession();
		
		EmpMapper dao = session.getMapper(EmpMapper.class);
		
		Condition cond = new Condition();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(7900);
		ids.add(7902);
		ids.add(7934);
		ids.add(7788);
		cond.setEmpnos(ids);
		List<Emp> list = dao.findByIds(cond);
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + " " + emp.getEname() + " "
					+ emp.getJob() + " " + emp.getSal());
		}

	}

	public static void main(String[] args) {
		TestEmp testEmp=new TestEmp();
//		testEmp.testFindByisHigh();
		testEmp.testfindByIds();
	}
}
