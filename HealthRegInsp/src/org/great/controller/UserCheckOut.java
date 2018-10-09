package org.great.controller;



import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.great.biz.BillBiz;
import org.great.biz.RefundBiz;
import org.great.tools.AlipayConfig;
import org.great.tools.AlipayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 支付宝action类 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-02 21:48 
*/ 
@Controller
@RequestMapping("/userCheckOut")
public class UserCheckOut {
	
	@Resource
	private BillBiz bdminBizImp;//账单业务接口
	
	@Resource
	private RefundBiz refundBizImp;//退款记录接口
	
	ModelAndView mav = new ModelAndView();
	
	/*
	 * @Description:（方法功能描述）支付宝支付
	* @throws AlipayApiException（展示方法参数和返回值）
	 */
	@RequestMapping("/payment.action")
	public void payment(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam String billId,String actCharge,String WIDsubject,String WIDbody) throws AlipayApiException {
		
			//商户订单号，商户网站订单系统中唯一订单号，必填
			String orderId = billId;
			//付款金额，必填
			String money = actCharge;
			//订单名称，必填
			String name = WIDsubject;
			//商品描述，可空
			String info = WIDbody;
			try {		
				String result = AlipayUtil.pay(response, money, info, name, orderId);
				
				request.setAttribute("result", result);	
						
				request.getRequestDispatcher("/FrontEnd/bill.jsp").forward(request,response);
			} catch (Exception e) {			
					e.printStackTrace();		
				}				
	}
	
	/*
	 * @Description:支付宝退款
	* @param request
	* @param response
	* @param billId
	* @param actCharge
	* @throws AlipayApiException（展示方法参数和返回值）
	 */
	@RequestMapping("/refund.action")
	public void refund(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String billId,String actCharge,String causeInfo,String soleId,Integer refundId) throws AlipayApiException{
		
		///商户订单号，商户网站订单系统中唯一订单号
		String orderId = billId;
		//请二选一设置
		//需要退款的金额，该金额不能大于订单金额，必填
		String money = actCharge;
		//退款的原因说明
		String info = causeInfo;
		//标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
		String signId = soleId;
			
		try {
			
			String result = AlipayUtil.refund(response, money, orderId, info, signId);
			
			request.setAttribute("result", result);	
			
			bdminBizImp.updateBill(145,Integer.valueOf(orderId));
			
			refundBizImp.updateRefund(145, refundId);
			
			request.getRequestDispatcher("/FrontEnd/bill.jsp").forward(request,response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
