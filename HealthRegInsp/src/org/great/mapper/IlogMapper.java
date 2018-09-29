package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.great.bean.LogBean;
import org.springframework.stereotype.Repository;

@Repository
public interface IlogMapper {
      //查询日志
	 public List<LogBean> selectAllLog(LogBean logBean,RowBounds rowBounds);
	 
	 //查询个数
	 public List<LogBean>  selectLogNu(LogBean logBean);
	 
	 //删除日志
	 public void  deleteLog(@Param("logId")int logId);
	 
	 //保存日志
	 public void  saveLog(LogBean log);
}
