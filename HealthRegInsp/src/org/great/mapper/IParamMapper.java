package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.bean.AdminBean;
import org.great.bean.ParamBean;
import org.great.search.AdminCon;
import org.springframework.stereotype.Repository;


/*
 * 参数Mapper
 */
@Repository
public interface IParamMapper {
	//获取分页参数内容
	public List<ParamBean> ParamList(@Param("statrRn")int statrRn,@Param("endRn")int endRn);
	
	//获得总的数据
	public List<ParamBean> AllParamList();
	
	//删除系统参数
	public int delParam(@Param("pid")int pid);
	
	//根据参数ID得到对应的参数信息
	public ParamBean getParamInfo(@Param("pid")int pid);
	
	//保存修改的参数内容
	public int updateParam(ParamBean param);
	
	//得到父级参数
	public List<ParamBean> getParamPar();
	
	//添加参数信息
	public int addParam(ParamBean param);

	
	/***************************  管 理  员 管 理  ****************************/
	//展示管理员列表（模糊查找、带分页）（L）
	public List<AdminBean> getFuzzyAdminList(AdminCon adminCon);
	
	//所有管理员列表（模糊查找）（L）
	public List<AdminBean> getAllFuzzyAdminList(AdminCon adminCon);
	
	//获得用户状态列表
	public List<ParamBean> userStates();
	
	//启用禁用管理员
	public int endisAdmin(@Param("id")int adid,@Param("val")int val);
	
	//重置密码
	public int resetPwd(@Param("id")int adid,@Param("pwd")String pwd);
	
	//删除管理员
	public int delAdmin(@Param("id")int adid,@Param("logic")int logic);
	
	//增加管理员
	public int addAdmin(AdminBean admin);
	
	//检验身份证号是否重复
	public AdminBean checkIdNum(@Param("idNum")String idNum);
	
	//维护关系表
	public int rela(@Param("roleId")int roleId,@Param("adminId")int adminId);
}
