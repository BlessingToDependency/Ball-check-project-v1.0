/**   
 * Copyright © 2018 传一科技.
 * 
 * @Package: org.great.biz 
 * @author: wjx(wangj)   
 * @date: 2018年9月19日 下午9:46:52 
 */
package org.great.biz;

import org.great.bean.TotalBean;

/** 
 * @ClassName: ReportBiz 
 * @Description: TODO
 * @author: wjx(wangj)  
 * @date: 2018年9月19日 下午9:46:52  
 */
public interface ReportBiz {

	//总结报告展示
	public TotalBean  showReport(String reportId);
	
}
