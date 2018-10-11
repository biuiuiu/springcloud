package com.zya.cloud.two.ui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * filter在请求进入servlet之前和离开servlet之前可以对request和response做处理
 * 对于UI的请求也一样
 * 
 * @author zya
 *
 */
@WebFilter(urlPatterns = "/two/*")
public class TestFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter");
		HttpServletRequest hrequest = (HttpServletRequest) request;
		System.out.println(hrequest.getParameterMap());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory");
	}

}
