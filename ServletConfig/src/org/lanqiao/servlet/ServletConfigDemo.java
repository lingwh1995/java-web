package org.lanqiao.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示ServletConfig的四个方法:
 * java.lang.String 	getInitParameter(java.lang.String name)  
 * java.util.Enumeration<java.lang.String> 	getInitParameterNames() 
 * ServletContext 	getServletContext() 
 * java.lang.String 	getServletName() 
 * 
 * @author ronin
 *
 */
public class ServletConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//1.获取servleConfig
		ServletConfig config = this.getServletConfig();
		//2.获取当前servlet的名称
		String servletName = config.getServletName();
		System.out.println("当前servlet名称:"+servletName);
		//3.获取初始化参数
		String user = config.getInitParameter("user");
		String password= config.getInitParameter("password");
		System.out.println(user+"---"+password);
		//4.获取初始化参数数组
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println("每一个参数的名称："+name);
		}
		//5.获取servletContext(Servlet的上下文环境,一般把名称命名为application)
		ServletContext context = config.getServletContext();
		System.out.println("ServletContext:"+context );
	}

}
