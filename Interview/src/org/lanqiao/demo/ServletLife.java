package org.lanqiao.demo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 演示Servlet生命周期(从生到死)
 * Servlet是单实例多线程:
 * 默认第一次访问的时候，服务器创建Servlet，并调用init方法实现初始化操作,并调用一次services方法(注意:services方法不管是通过前台访问servlet还是直接访问后台servlet都会执行)
 * 每次当请求来的时候,服务器会创建一个线程,调用services方法执行自己的业务逻辑
 * 当servlet被移除的时候或者服务器被正常关闭的时候,服务器调用servlet的desctroy方法实现销毁操作
 */
public class ServletLife implements Servlet {
	
	/**
	 * 初始化方法
	 * 创建者:服务器
	 * 执行者:服务器
	 * 执行次数:1次
	 * 执行时机:默认第一次访问的时候
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()...");
	}
	
	/**
	 * 服务方法
	 * 创建者:访问的用户
	 * 执行者:服务器
	 * 执行次数:访问一次执行一次
	 * 执行时机:
	 */
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("services...");
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 销毁方法
	 * 执行者:服务器
	 * 执行次数:一次
	 * 执行时机:Servlet被移除的时候或者服务器正常关闭的时候   
	 */
	@Override
	public void destroy() {
		System.out.println("destory...");
	}
	

}
