package org.great.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.great.bean.AdminBean;
import org.great.bean.FinresultBean;
import org.great.bean.LitemBean;
import org.great.bean.SetmealBean;
import org.great.bean.StaffBean;
import org.great.bean.TermBean;
import org.great.bean.UserBean;
import org.springframework.stereotype.Repository;
/*
 * 后台Mapper
 */
@Repository
public interface IAdminMapper {
	//后台登陆
	public AdminBean adminLogin(AdminBean adminBean);
	
	//后台新增用户（注册）
	public void adminRegister(AdminBean adminBean);
	
	//通过导检单id和科室id查询细项
	public List<TermBean> selectSetmeal(@Param("guChId")String guChId,@Param("depaId")Integer depaId);
	
	//查询当前公司下用户并下载
	public List<StaffBean> exportExcel(@Param("staffName")String staffName,@Param("phone")Long phone,@Param("statTime")String statTime,@Param("stopTime")String stopTime,@Param("partYear")String partYear,@Param("companyId")Integer companyId,@Param("myGuChId")String myGuChId);
	
	//通过导检单id查询项目id
	public Integer selectItem(@Param("guChId")String guChId,@Param("depaId")Integer depaId);
	
	//科室插入体检人员信息
	public void addFinresult(FinresultBean finresultBean);
	
	//后台用户公司展示
	public List<UserBean> company(@Param(value="userBean")UserBean userBean,@Param(value="pages")Integer pages);

	//禁用公司
	public void disableCompany(@Param(value="companyId")String companyId,@Param(value="stateId")String stateId);
	
	//删除公司
	public void deleteCompany(@Param(value="companyId")String companyId,@Param(value="logicId")String logicId);
		
	//后台用户公司总数
	public Integer companyCount(UserBean userBean);
	
	//后台用户管理列表展示
	public List<StaffBean> userAdmin(@Param("staffName")String staffName,@Param("phone")Long phone,@Param("statTime")String statTime,@Param("stopTime")String stopTime,@Param("partYear")String partYear,@Param("companyId")Integer companyId,@Param("pages")Integer pages,@Param("myGuChId")String myGuChId);
	
	//后台用户管理列表总数查询
	public Integer userAdminCount(@Param("staffName")String staffName,@Param("phone")Long phone,@Param("statTime")String statTime,@Param("stopTime")String stopTime,@Param("partYear")String partYear,@Param("companyId")Integer companyId,@Param("myGuChId")String myGuChId);
	
	//根据用户id查找对应信息
	public StaffBean userInfo(@Param("staffId")String staffId);
	
	//后台修改密码
	public  void  updateAdminPws(@Param("adminPwd")String adminPwd,@Param("adminId")int adminId);
	
	//后台禁用启用医生
	public void  updateDoctorState(AdminBean adminBean);
	
	//后台逻辑删除医生
	public void  logicDeleteDoc(AdminBean adminBean);
	
	//后台对医生信息进行修改
	public void updateDoctorInfo(AdminBean adminBean);
	
	//查询医生信息
	public List<AdminBean> slectDoctorInfo(@Param("adminId")int adminId);
	
	//增加项目
	public void addItem(LitemBean litemBean);

	
	//查询项目(通用)
	public LitemBean selectLitem(LitemBean litemBean);
	
	


		
	//查询项目(通用 模糊分页  排序)
	public List<LitemBean> selectLitem(@Param(value="litemBean")LitemBean litemBean,@Param("peakPrice")String peakPrice,@Param("bottomPrice")String bottomPrice,
			@Param("rank")String rank,@Param("page")Integer page);
		
	//查询项目总数(通用)
	public Integer selectLitemSum(@Param(value="litemBean")LitemBean litemBean,@Param("peakPrice")String peakPrice,@Param("bottomPrice")String bottomPrice);

	//查询指定项目的细项
	public List<TermBean> selectTerm(LitemBean litemBean);
	
	//管理医生(查看所有医生)
	public List<AdminBean> selectAllDoctor(@Param("adminBean")AdminBean adminBean,RowBounds rowBounds);
	
	//查询医生（个数）
	public List<AdminBean> selectAllDoctorN(@Param("adminBean")AdminBean adminBean);
	
	//新增医生查重
	public List<AdminBean>  cheackDoctor(AdminBean adminBean);
	
	//医生更改角色
	public void updateRole(@Param("adminId") int adminId,@Param("roleId") int roleId);


}
