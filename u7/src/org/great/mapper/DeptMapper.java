package org.great.mapper;

import java.util.ArrayList;
import java.util.List;

import org.great.entity.Dept;

 public interface DeptMapper {
	
	public int addDept(Dept dept);

	public void deleteById(int id);
	
	public Dept findById(int id);
	
	public ArrayList findAll();
	
	public void updateDept(Dept dept);
	
	

}
