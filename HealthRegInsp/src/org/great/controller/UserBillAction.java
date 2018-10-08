package org.great.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.bean.AdminBean;
import org.great.bean.BillBean;
import org.great.bean.LitemBean;
import org.great.bean.PersonalBean;
import org.great.bean.RefundBean;
import org.great.bean.UserBean;
import org.great.biz.BillBiz;
import org.great.biz.PersonalBiz;
import org.great.biz.RefundBiz;
import org.great.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*
 * 前台记账
 */
@Component
@RequestMapping("/userBillAction")
public class UserBillAction {
	

	@Resource
	private BillBean billBean;//账单Bean
	
	@Resource
	private UserBiz userBizImpl;//前台用户接口
	
	@Resource
	private BillBiz bdminBizImp;//账单业务接口
	
	@Resource
	private PersonalBiz personalBizImp;//个人账单业务接口
	
	@Resource
	private RefundBiz refundBizImp;//退款记录接口
	
	ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="userBill.action")
	public ModelAndView userBill(HttpServletRequest request,BillBean billBean) {
		
		//获取当前账号的信息
		UserBean ub =  (UserBean) request.getSession().getAttribute("userBean");
		
		//把公司id塞进账单bean
		billBean.setCompanyId(ub.getCompanyId());
		
		//账单信息增加进数据库
		userBizImpl.userBill(billBean);
		
		mav.setViewName("success");//增加成功调到主页面
		
		return mav;
		
	}
	/*
	 * @Description:查询账单 
	* @return（展示方法参数和返回值）
	 */
	@RequestMapping("/billInfo.action")
	public ModelAndView billInfo(HttpServletRequest request,Model model,
			@RequestParam String startTime,String endTime,String paramId,Integer page) {
		
		if(startTime.equals("请输入开始时间")) {
			startTime = "";
		}
		if(endTime.equals("请输入结束时间")) {
			endTime = "";
		}
		if(paramId.equals("请输入支付状态")) {
			paramId = "";
		}
		
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		
		//查询账单的总数
		Integer sum = bdminBizImp.selectBillSum(startTime, endTime, paramId,userBean.getCompanyId());
		
		model.addAttribute("sum", sum);
		
		Integer p = (int) Math.ceil(Double.valueOf(sum)/10);
		model.addAttribute("p", p);
		
		if(page<1) {
			page = 1;
		}else if(page>p) {
			page = page - 1;
		}
		
		//调用查询账单方法
		List<BillBean> list = bdminBizImp.selectAllBill(startTime, endTime, paramId, page,userBean.getCompanyId());
		
		System.out.println(list.toString());
		
		//调用SpingMVC的封装方法  和request的返回方法一致
		model.addAttribute("list", list);
		
				
		if(startTime.equals("")) {
			startTime = "请输入开始时间";
		}
		if(endTime.equals("")) {
			endTime = "请输入结束时间";
		}
		if(paramId.equals("")) {
			paramId = "请输入支付状态";
		}
		
		model.addAttribute("startTime", startTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("paramId", paramId);		
		model.addAttribute("page", page);

		
		mav.setViewName("FrontEnd/user_Bill");
		return mav;
	}
	
	/*
	 * @Description:提交退款申请 
	* @param bill
	* @return（展示方法参数和返回值）
	 */
	@RequestMapping("/refundCause.action")
	@ResponseBody
	public Map<String,Object> refundCause(BillBean bill){
		
		System.out.println(bill.toString());
		
		Double money = 0.0;
		
		//获取对应公司下某个账单的个人账单
		List<PersonalBean> list = personalBizImp.selectPersonal(bill);
		
		Iterator<PersonalBean> it = list.iterator();
		
		while(it.hasNext()) {
			PersonalBean pb = it.next();
			money = money + Double.valueOf(pb.getCost());
			System.out.println("金额："+money);
		}
		
		DecimalFormat  df  = new DecimalFormat("######0.0");
		System.out.println("退款金额："+money);
		
		String reMoney = df.format(money);
		Map<String,Object> maps = new HashMap<String, Object>();
		
		maps.put("money", reMoney);
		maps.put("bill", bill);
		
		return maps;
	}
	
	/*
	 * @Description:增加退款记录 
	* @param rersonal
	* @return（展示方法参数和返回值）
	 */
	@RequestMapping("/addRefundCause.action")
	@ResponseBody
	public Map<String,Object> addRefundCause(RefundBean refundBean){
		
		System.out.println(refundBean.toString());
		
		
		refundBizImp.insertRefund(refundBean);
		
		bdminBizImp.updateBill(144, refundBean.getBillId());
		Map<String,Object> maps = new HashMap<String, Object>();
		
		maps.put("money", "申请成功！");
		
		return maps;	
	}
}
