package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.great.bean.LogBean;

/*
 * 日志
 */
public interface ILogBiz {
	 //查询日志
	 public List<LogBean> selectAllLog(RowBounds rowBounds,LogBean logBean); 
	 
	 //查询个数
	 public List<LogBean>  selectLogNu(LogBean logBean);
	 
	 //删除日志
	 public void  deleteLog(int logId);
}
