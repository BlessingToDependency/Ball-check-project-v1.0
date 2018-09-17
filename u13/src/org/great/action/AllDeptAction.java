package org.great.action;

import java.util.List;

import javax.annotation.Resource;

import org.great.biz.DeptBiz;
import org.great.entity.Dept;
import org.great.mapper.DeptMapper;
import org.springframework.stereotype.Controller;

@Controller
public class AllDeptAction {

	private List<Dept> depts;// out
	@Resource
	 private DeptBiz deptBizImpl;
	public String execute() {
		depts = deptBizImpl.findAll();
		if (depts != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	 
}
