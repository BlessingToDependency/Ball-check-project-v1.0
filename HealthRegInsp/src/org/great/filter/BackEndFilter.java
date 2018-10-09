package org.great.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * 后端安全过滤层
 */
public class BackEndFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hsr= (HttpServletRequest) request;
		HttpServletResponse hr=(HttpServletResponse) response;
		//创建一个session对象
		HttpSession session= hsr.getSession();
		int t = 0;
		//获得请求进来的url地址
		String url=hsr.getRequestURI();
		int b =url.indexOf(".js");
		if(b>0) {
			String str=url.substring(b);
			if(str.equals(".jsp")) {
				t=1;
			}
		}
		if(url.equals("/HealthRegInsp/BackEnd/admin_login.jsp")) {
			//进行放行
			chain.doFilter(request, response);
		}else {
			//进行判断是否为css、js样式请求
			if(url.indexOf(".css")>0 || url.indexOf(".png")>0 || url.indexOf(".jpg")>0 || (url.indexOf(".js")>0 && t==0)) {
				//进行放行
				chain.doFilter(request, response);
			}else {
				if(session.getAttribute("adminBean")==null) {
					//页面转发
					hr.sendRedirect("/HealthRegInsp/BackEnd/admin_login.jsp");
				}
			}
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
