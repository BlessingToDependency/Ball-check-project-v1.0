package org.great.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.great.tools.AlipayConfig;
import org.great.tools.AlipayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alipay.api.AlipayApiException;
/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 支付宝action类 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-02 21:48 
*/ 
@Controller
@RequestMapping("/userCheckOut")
public class UserCheckOut {
	
	@RequestMapping("/payment.action")
	public void payment(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam String billId,String actCharge,String WIDsubject,String WIDbody) throws AlipayApiException {

			System.out.println("11111");
		
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
				System.out.println(result);		
				request.getRequestDispatcher("/FrontEnd/bill.jsp").forward(request,response);
			} catch (Exception e) {			
					e.printStackTrace();		
				}				
	}

}
