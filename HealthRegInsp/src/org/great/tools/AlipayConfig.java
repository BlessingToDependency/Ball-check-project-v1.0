package org.great.tools;

/** @version:（JAVA版本）java version "1.8.0_131" 
* @Description: 支付宝基础配置类 
* @author: （作者名）LYQ  
* @date: （日期）2018-10-02 21:46 
*/ 
public class AlipayConfig {
	
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
		public static String app_id = "2016092100560987";
		
		// 商户私钥，您的PKCS8格式RSA2私钥
	    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCucvuYqL9b9/Q+PBXjfX8iBIMx3b2S2h+yq+CM8eqY1TlVKb8JjZgcX1FRalvBd525J5y+hSY/D2UdROoTB1v8aPhwbfFQ1RampedI9LteQc2lsmb9yJ+C+idP9/djr6pw0eWZ0Ldudc/SlZApoEZyxVkZbwSJwL1VgfiV54F7tm0PuEBMcuAQSCpu/aRWznaAQO7lbrwFliIXdM2oNpbd5cdbeHkaW5VFNrj36mqaLqkyRE6b1mmSeLPt69rN+pvlB1PJ6Zgz4MlT7OcxRhUxnWvGi8OKnNzdOMZy8wT1Dga65kvrvtckJTpDzd5DrevUE2YbvUIjBgmg5KkYegRlAgMBAAECggEAZETY0i0kGFOTwnW8yw4mFcJsOixOu2q+T281WS3vfrsIAihFktMc/CnZTqeIZ9I+CN9425Uin5pUrxceR6OyPomDSvQWgTSJmW3AW5G3ZH0EG9pIElTPQnRQRkmrm1Or7r7mbpul40q6Ejs/Kn3iIDPIe7Lw89ChwtU6scboCNeiRpP6xATzoQylCD9fSjpyJe8UvvQSumeQzq8CbFggjYQ/Ehh2i4nHymDGXqBMvvLdFsjAc45XOarpPwlvok4PBfZ+snKOiLZ3FKRxhljHNKn8LrGbeC6kRoS3AoK+wY2eCl0GKW4cnFsdGXMUaXRCmnwGi9yjLf4uh/mOUrwEYQKBgQD89sEl+CNapJFVLsmBfRRguZBixTuVfXGSH81rr85yVl3lpQB7V1ckKmi474on1V4TbTG4q6Df5H3IYvAooigM9qwLhrX9bo6F2yVBDYF2KsYN5ghQfn7ZJrSt0jxlw0bVuvxqFaFdSEhiQVcxcC0BGWh31cK8Rr7KVe873iKIPQKBgQCwivzJ7qTQWNpzU9B0eUCKyaosw3ZYWa7fuVlX0kp3EBy2AU9TgeU+6jWL2gk8KU96/TBGp1RvIJ8iJIPBQpkdsEOyDo0KYxkjMJvzBlUUsneXVvaLx5CZcvFrpYwJOyP3hpOhTFEZM8/k7NElGU7UZ+ozoLDd/LoYw9bZaX2HSQKBgQCg/6+YqeBefWUeMQQBDQmeMhxqMJumnktdNC56vk8HyF5EnYq79a+5jeBO6+4jQhJ5DMNbhKiENxmzIv0071fMQGbpgxhrLyU4nmyMhbsC6WBaUjCygn/bV14hTzAvmGSJ/VNPdWrZQvsGxg1noryR+Yja1Er3p5MglicIFG4oBQKBgDUu+a5fjRkS22RIyJB+ApqM3A42KA2/nrXZIXgaasJpgSy3Qk124TfN2Kmz2npcO4xif8uZFw+PNUFU3Lg4tuXBtvMJ/SU261i1iRVyP+lHRk26LfW3/fCsNtxl98TEIzarPQgndHryJ9vgF7VkZWIJl/1LmFyXiPxy6uN+Kwm5AoGAHhUbqJHM8F/ZPb/9nBw83bu8TN27Rj+/21etCtE/mvalvqJontotdN/qZB/KRnc7cqI8UTE73pEa20Ht4KpwDybXaCp+3W67us6vCDdthy/jPXSR0othFNa3REEUehsDaTfWX8XWLko8UGaV3d82I/WN/T5iyJ9gz90ImIXOwj8=";
		
		// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1bVjwzQHjJJPDrSnTDyNx0R4oSkQ+NMNAnQa0DdeLnc3U6vdmo7a3TP245/m8QxLRysv/eIiZnAtzGtTxgCsF2Aav39QbZDHDBZuLPNLSSgxF8TM+FOk63yXrVTE/mOoNCG00vmuzI4J5Hr3ATxizEgubxBktgbkMJFPTPldOgSoSpbGWBMv0J2FQOHuGdeLvcxe9GcnSwQogF4+uFtwwGvjpXH0Bt4l/mIJlhEfAAL8BMtMk1wupZwNTPhcUZzlTaCmiDVTojWxABk8uLUyqEmrZTJ5hk5XKC/vhLjEZoVvYbb2oQh5VCNvsgFPq4Z3jywWEcsopj6FhEyT/iTXLwIDAQAB";

		// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String notify_url = "http://localhost:8080/HealthRegInsp/userBillAction/paySuccess.action";
		
		// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String return_url = "http://localhost:8080/HealthRegInsp/userBillAction/paySuccess.action";

		// 签名方式
		public static String sign_type = "RSA2";
		
		// 字符编码格式
		public static String charset = "utf-8";
		
		// 返回格式
		public static String FORMAT = "json";
		
		// 支付宝网关
		public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
		
		// 支付宝网关
		public static String log_path = "D:\\test";

}
