package org.great.controller;
/*
 * 前台主页套餐展示
 */

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.bean.SetmealBean;
import org.great.bean.UserBean;
import org.great.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


@Controller
@Scope("prototype")//每次获取Bean的时候会有一个新的实例
@RequestMapping("/userMainAction")
public class UserMainAction {

	@Resource
	private SetmealBean setmealBean;
	ModelAndView mav = new ModelAndView();
	@Resource
	private UserBiz userBizImp;//前台用户接口
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	//主页展示套餐
	@RequestMapping("showSetmeal.action")
	public ModelAndView showSetmeal(String setmealId) throws Exception{
		List<SetmealBean> setList=userBizImp.showSetmeal(setmealId);
		int count = 0;
		for(int i=0;i<setList.size();i++) {
			SetmealBean sb = setList.get(i);
			int countAll = 0;
			for(int j =0;j<setList.get(i).getLitemBean().size();j++) {
				count = setList.get(i).getLitemBean().get(j).getPrice();
				countAll = countAll+count;
			}
			sb.setCountAll(countAll);
		}  
		if(null != setmealId) {
			
			mav.setViewName("FrontEnd/commodity");
		}else {
			mav.setViewName("FrontEnd/user_index");
		}
		System.out.println(setList.size());
		mav.addObject("setList", setList);
		return mav;
	}
	
	/*
	 * 现在购买
	 */
	@RequestMapping("buyNow.action")
	public ModelAndView buyNow(SetmealBean setmealBean) throws Exception{
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		if(null != userBean) {
			System.out.println("购买");
			File f=new File("upload/体检表.xls");
			Workbook book=Workbook.getWorkbook(f);// 
			Sheet sheet=book.getSheet(0); //获得第一个工作表对象 
			for(int i=0;i<sheet.getRows();i++){ 
				for(int j=0;j<sheet.getColumns();j++){ 
					Cell cell=sheet.getCell(j, i); //获得单元格 
					System.out.print(cell.getContents()+" "); 
				} 
				System.out.print("\n"); 
			}
			
			mav.addObject("setmealBean", setmealBean);
			mav.setViewName("FrontEnd/user_buynow");
		}else {
			System.out.println("登陆去");
			mav.setViewName("FrontEnd/user_login");
		}
		return mav;
	}
	
	
}
