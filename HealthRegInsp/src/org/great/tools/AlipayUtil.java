package org.great.tools;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;

 
/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 支付宝 支付 退款 的封装类 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-07 19:32 
*/ 
public class AlipayUtil {
 
	public static String pay(HttpServletResponse response,String money,String info,String name,String orderId) throws Exception{
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ orderId +"\"," 
				+ "\"total_amount\":\""+ money +"\"," 
				+ "\"subject\":\""+ name +"\"," 
				+ "\"body\":\""+ info +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		
		//请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		
		//返回
		return result;
	}
	
	public static String refund(HttpServletResponse response,String money,String orderId,String info,String signId) throws AlipayApiException, UnsupportedEncodingException {
		
		//获得初始化的AlipayClient		
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);				
		//设置请求参数		
		AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

		alipayRequest.setBizContent("{\"out_trade_no\":\""+ orderId +"\"," 				
				+ "\"refund_amount\":\""+ money +"\"," 
				+ "\"refund_reason\":\""+ info +"\"," 
				+ "\"out_request_no\":\""+ signId +"\"}");
		
		//请求并获取返回过来的消息
		String result = alipayClient.execute(alipayRequest).getBody();
		
		
		//把从请求过来的消息，转换为json数据		
		JSONObject resultJsonAll = JSONObject.parseObject(result);	
		System.out.println(resultJsonAll);
		JSONObject results = JSONObject.parseObject(resultJsonAll.getString("alipay_trade_refund_response"));				
		System.out.println(results);
		//获取退款消息		
		String mess = results.getString("msg");			
		//如果返回过来的消息等于Success 则调用退款接口成功		
		if("Success".equals(mess)) {			
			return "退款成功!";		
			}else {			
			return "退款失败!";		
		}	

	}
}

