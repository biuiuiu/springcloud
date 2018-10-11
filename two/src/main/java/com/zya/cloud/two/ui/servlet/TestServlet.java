package com.zya.cloud.two.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过注解注册自定义servlet，满足URLpattern的请求会被拦截，不进入对应的UI
 * 
 * @author zya
 *
 */
//@WebServlet(urlPatterns = "/two/*")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 7160155402907141056L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----------doGet----------------");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----------doPost----------------");
		resp.getWriter().print("<h1>Hello MyServlet Response return you this</h1>");
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}
}
