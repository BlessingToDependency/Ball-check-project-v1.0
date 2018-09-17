package org.great.mapper;

import java.util.List;

import org.great.annotation.MyBatisRepository;
import org.great.entity.Dept;
import org.springframework.stereotype.Repository;

//@MyBatisRepository("mapper")
@Repository("mapper")
public interface DeptMapper {
	
	public List<Dept>findAll();


}
