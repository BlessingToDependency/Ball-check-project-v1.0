package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.LogBean;
import org.great.mapper.IlogMapper;
import org.springframework.stereotype.Service;
@Service
public class LogBizImp implements ILogBiz {
	@Resource
	private IlogMapper ilogMapper;
	
	//查询所有日志
	@Override
	public List<LogBean> selectAllLog(RowBounds rowBounds,LogBean logBean) {
		// TODO Auto-generated method stub
		List<LogBean> logList=ilogMapper.selectAllLog(logBean,rowBounds);
		return logList;
	}
   
	//查询个数
	@Override
	public List<LogBean> selectLogNu(LogBean logBean) {
		// TODO Auto-generated method stub
		List<LogBean> logList=ilogMapper.selectLogNu(logBean);
		return logList;
	}

	//删除日志
	@Override
	public void deleteLog(int logId) {
		// TODO Auto-generated method stub
		ilogMapper.deleteLog(logId);
		
	}

	//保存日志
	@Override
	public void saveLog(LogBean log) {
		// TODO Auto-generated method stub
		ilogMapper.saveLog(log);
		
	}

}
