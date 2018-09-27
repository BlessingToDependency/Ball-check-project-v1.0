package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.great.bean.DeparBean;
import org.springframework.stereotype.Repository;

/*
 * 科室Mapper
 */
@Repository
public interface IDeparMapper {
    //查询所有科室
	public List<DeparBean>  selectAllDepar();
	
	
	//带分页模糊查找科室
	public List<DeparBean> selectDe(DeparBean deparBean,RowBounds rowBounds);
	
	//查询个数
	public List<DeparBean> selectDeN(DeparBean deparBean);
	
	//增加科室
	public  void  innserDepar(@Param("depar")String depar);
	
	//删除科室
	public void  deleteDepar(@Param("depaId")int depaId);
	
	//修改科室名
	public  void  updateDepar(DeparBean deparBean);
	
	//去重
	public List<DeparBean> selectDeChe(DeparBean deparBean);
}
