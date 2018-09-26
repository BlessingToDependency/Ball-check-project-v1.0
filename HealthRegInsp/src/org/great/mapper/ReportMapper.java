/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.mapper 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午4:58:57 
 */
package org.great.mapper;

import org.apache.ibatis.annotations.Param;
import org.great.bean.TotalBean;
import org.springframework.stereotype.Repository;

/** 
 * @ClassName: IReportMapper 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午4:58:57  
 */
@Repository
public interface ReportMapper {

	//总结报告单
	public  TotalBean  showReport(@Param("guChId")String reportId);
	
}
