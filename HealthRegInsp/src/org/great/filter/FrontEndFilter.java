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
 * 前端安全过滤层
 */
public class FrontEndFilter implements Filter{

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
		//获得请求进来的url地址
		String url=hsr.getRequestURI();
		//进行判断是否为css、js样式请求
		if(url.indexOf(".css")>0 && url.indexOf(".js")>0) {
			//进行放行
			chain.doFilter(request, response);
		}else {
			if(session.getAttribute("userBean")==null) {
				//页面转发
				hsr.getRequestDispatcher("/FrontEnd/user_login.jsp").forward(request, response);
			}
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
