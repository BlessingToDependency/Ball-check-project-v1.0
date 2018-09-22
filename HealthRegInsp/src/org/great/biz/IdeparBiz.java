package org.great.biz;

import java.util.List;

import org.great.bean.DeparBean;

/*
 * 科室Biz接口
 */
public interface IdeparBiz {
	 //查询所有科室
		public List<DeparBean>  selectAllDepar();
}
