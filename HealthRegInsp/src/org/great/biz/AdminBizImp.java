package org.great.biz;

import java.util.ArrayList;
import java.util.List;


import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.great.bean.AdminBean;
import org.great.bean.LitemBean;
import org.great.bean.StaffBean;
import org.great.bean.TermBean;
import org.great.bean.UserBean;
import org.great.mapper.IAdminMapper;
import org.springframework.stereotype.Service;

/*
 * 后台biz
 */
@Service
public class AdminBizImp implements AdminBiz{
	@Resource
	IAdminMapper iAdminMapper;
	private List<StaffBean> userList = new ArrayList<StaffBean>();
	//登陆
	@Override
	public AdminBean adminLogin(AdminBean adminBean) {
		// TODO Auto-generated method stub
		AdminBean aBean = iAdminMapper.adminLogin(adminBean);
		return aBean;
	}

	
	//注册
	@Override
	public void adminRegister(AdminBean adminBean) {
		// TODO Auto-generated method stub
		iAdminMapper.adminRegister(adminBean);
	}


	//后台用户管理列表展示
	@Override
	public List<StaffBean> userAdmin(String staffName,Long phone,String statTime,String stopTime,String partYear,Integer pages) {
		// TODO Auto-generated method stub
		userList = iAdminMapper.userAdmin( staffName, phone, statTime, stopTime, partYear,pages);
		return userList;
	}

	//后台用户管理总数
	@Override
	public Integer userAdminCount(String staffName,Long phone,String statTime,String stopTime,String partYear) {
		// TODO Auto-generated method stub
		return iAdminMapper.userAdminCount( staffName, phone, statTime, stopTime, partYear);
	}
	
	//根据用户id查找对应信息
	public StaffBean userInfo(String staffId) {
		return iAdminMapper.userInfo(staffId);
	}
	
    //修改密码
	@Override
	public void updateAdminPws(String adminPwd,int adminId) {
		// TODO Auto-generated method stub
		iAdminMapper.updateAdminPws(adminPwd,adminId);
	}

	//后台禁用启用医生
	@Override
	public void updateDoctorState(AdminBean adminBean) {
		// TODO Auto-generated method stub
		iAdminMapper.updateDoctorState(adminBean);
	}

   //后台逻辑删除医生
	@Override
	public void logicDeleteDoc(AdminBean adminBean) {
		// TODO Auto-generated method stub
		iAdminMapper.logicDeleteDoc(adminBean);
	}

	//后台对医生信息进行修改
	@Override
	public void updateDoctorInfo(AdminBean adminBean) {
		// TODO Auto-generated method stub
		iAdminMapper.updateDoctorInfo(adminBean);
	}

	//查询医生信息
	@Override
	public List<AdminBean> slectDoctorInfo(int adminId) {
		// TODO Auto-generated method stub
		 List<AdminBean> adminList=iAdminMapper.slectDoctorInfo(adminId);
		return adminList;

	}

	//增加项目
	@Override
	public void addItem(LitemBean litemBean) {
		// TODO Auto-generated method stub
		iAdminMapper.addItem(litemBean);
	}

	//查询项目(通用 模糊分页  排序)
	@Override
	public List<LitemBean> selectLitem(LitemBean litemBean, String peakPrice, String bottomPrice, String rank, Integer page) {
		// TODO Auto-generated method stub
		List<LitemBean> list = iAdminMapper.selectLitem(litemBean, peakPrice, bottomPrice, rank, page);
		return list;
	}

	//查询项目总数(通用)
	@Override
	public Integer selectLitemSum(LitemBean litemBean, String peakPrice, String bottomPrice) {
		// TODO Auto-generated method stub
		Integer i = iAdminMapper.selectLitemSum(litemBean, peakPrice, bottomPrice);
		return i;
	}

	//查询指定项目的细项
	@Override
	public List<TermBean> selectTerm(LitemBean litemBean) {
		// TODO Auto-generated method stub
		List<TermBean> list = iAdminMapper.selectTerm(litemBean);
		return list;
	}
	
	//管理医生(查看所有医生)
		@Override
		public List<AdminBean> selectAllDoctor(AdminBean adminBean, RowBounds rowBounds) {
			// TODO Auto-generated method stub
			List<AdminBean> adList=iAdminMapper.selectAllDoctor(adminBean, rowBounds);
			return adList;
		}

		//查询医生（个数）
		@Override
		public List<AdminBean> selectAllDoctorN(AdminBean adminBean) {
			// TODO Auto-generated method stub
			List<AdminBean> adListN=iAdminMapper.selectAllDoctorN(adminBean);
			return adListN;
		}


		//新增医生查重
		@Override
		public List<AdminBean> cheackDoctor(AdminBean adminBean) {
			// TODO Auto-generated method stub
			List<AdminBean> al=iAdminMapper.cheackDoctor(adminBean);
			return al;
		}
	
}
