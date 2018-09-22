package org.great.mapper;

import java.util.List;

import org.great.bean.PostBean;
import org.springframework.stereotype.Repository;
/*
 * 职务Mapper
 */
@Repository
public interface IpostMapper {
    //查询所有职务
	public List<PostBean> selectAllPost();
}
