package org.great.biz;
/*
 * 职务
 * 
 */

import java.util.List;

import org.great.bean.PostBean;

public interface PostBiz {
	 //查询所有职务
	public List<PostBean> selectAllPost();
}
