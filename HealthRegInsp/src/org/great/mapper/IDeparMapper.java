package org.great.mapper;

import java.util.List;

import org.great.bean.DeparBean;
import org.springframework.stereotype.Repository;

/*
 * 科室Mapper
 */
@Repository
public interface IDeparMapper {
    //查询所有科室
	public List<DeparBean>  selectAllDepar();
}
