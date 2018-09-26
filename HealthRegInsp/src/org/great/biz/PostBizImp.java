package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.bean.PostBean;
import org.great.mapper.IpostMapper;
import org.springframework.stereotype.Service;
@Service
public class PostBizImp implements PostBiz{
	@Resource
	IpostMapper ipostMapper;
	
	public List<PostBean> selectAllPost() {
		// TODO Auto-generated method stub
		  List<PostBean> postList=ipostMapper.selectAllPost();
		return postList;
	}

}
