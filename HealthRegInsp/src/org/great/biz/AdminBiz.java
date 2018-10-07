package org.great.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.great.bean.AdminBean;
import org.great.bean.DeparBean;
import org.great.bean.FinresultBean;
import org.great.bean.LitemBean;
import org.great.bean.SetmealBean;
import org.great.bean.StaffBean;
import org.great.bean.TermBean;
import org.great.bean.UserBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public interface AdminBiz {
	//后台登陆
	public AdminBean adminLogin(AdminBean adminBean);
	
	//后台新增用户（注册）
	public void adminRegister(AdminBean adminBean);
	
	//查询当前公司下用户并下载
	public List<StaffBean> exportExcel(String staffName,Long phone,String statTime,String stopTime,String partYear,Integer companyId,String myGuChId);
	
	//通过导检单id和科室id查询细项
	public List<TermBean> selectSetmeal(String guChId,Integer depaId);
	
	//通过导检单id查询项目id
	public Integer selectItem(String guChId,Integer depaId);
	
	//科室插入体检人员信息
	public void addFinresult(FinresultBean finresultBean);
	
	//后台用户公司展示
	public List<UserBean> company(UserBean userBean,Integer pages);
	
	//禁用公司
	public void disableCompany(String companyId,String stateId);
	
	//删除公司
	public void deleteCompany(String companyId,String logicId);
	
	//后台用户公司总数
	public Integer companyCount(@Param(value="userBean")UserBean userBean);

	//后台用户管理列表展示
	public List<StaffBean> userAdmin(String staffName,Long phone,String statTime,String stopTime,String partYear,Integer companyId,Integer pages,String myGuChId);
	//后台用户管理列表总数查询
	public Integer userAdminCount(String staffName,Long phone,String statTime,String stopTime,String partYear,Integer companyId1,String myGuChId);
	
	//根据用户id查找对应信息
	public StaffBean userInfo(String staffId);
	
	//后台修改密码
	public  void  updateAdminPws(String adminPwd,int adminId);
	
	//后台禁用启用医生
	public void  updateDoctorState(AdminBean adminBean);
	
	//后台逻辑删除医生
	public void  logicDeleteDoc(AdminBean adminBean);
		
	//后台对医生信息进行修改
	public void updateDoctorInfo(AdminBean adminBean);
	
	//查询医生信息
	public  List<AdminBean> slectDoctorInfo(int adminId);
	
	//增加项目
	public void addItem(LitemBean litemBean);


	//查询项目(通用 模糊分页  排序)
	public List<LitemBean> selectLitem(@Param("litemBean")LitemBean litemBean,@Param("peakPrice")String peakPrice,@Param("bottomPrice")String bottomPrice,
				@Param("rank")String rank,@Param("page")Integer page);
		
	//查询项目总数(通用)
	public Integer selectLitemSum(@Param("litemBean")LitemBean litemBean,@Param("peakPrice")String peakPrice,@Param("bottomPrice")String bottomPrice);

	//查询指定项目的细项
	public List<TermBean> selectTerm(LitemBean litemBean);
	
	//管理医生(查看所有医生)
	public List<AdminBean> selectAllDoctor(AdminBean adminBean,RowBounds rowBounds);
		
	//查询医生（个数）
	public List<AdminBean> selectAllDoctorN(AdminBean adminBean);
		
	//新增医生查重
	public List<AdminBean>  cheackDoctor(AdminBean adminBean);
	
	//医生更改角色
	public void updateRole( int adminId,int roleId);
	
	//得到科室对应需要调整的体检界面
	public DeparBean getIntfaceId(int depaId);
	
	//科室插入体检人员信息
	public void addFinresult2(FinresultBean finresultBean);
	
	//更新人员来体检的时间
	public int updateInspTime(int staffId,String inspTime);

}
