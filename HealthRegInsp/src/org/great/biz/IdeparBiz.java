package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.great.bean.DeparBean;
import org.great.bean.ParamBean;

/*
 * 科室Biz接口
 */
public interface IdeparBiz {
	 //查询所有科室
		public List<DeparBean>  selectAllDepar();
		
		//带分页模糊查找科室
		public List<DeparBean> selectDe(DeparBean deparBean,RowBounds rowBounds);	
		
		//去重，查询个数
		public List<DeparBean> selectDeN(DeparBean deparBean);
		
		//增加科室
		public  void  innserDepar(String depar,int intfaceId);
		
		//删除科室
		public void  deleteDepar(int depaId);
		
		//修改科室名
		public  void  updateDepar(DeparBean deparBean);
		
		//去重
		public List<DeparBean> selectDeChe(DeparBean deparBean);
		
		//查询配置的小结
		public List<ParamBean>  selectX();
}
