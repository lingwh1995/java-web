package org.lanqiao.demo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CServlet extends HttpServlet {
	private ServletConfig sconfig;;
	@Override
	public void init(ServletConfig config) throws ServletException {
		/**
		 * 注意：这些代码如果写在init()方法中就意味着只能被调用一次，即在初始化的时候被调用一次
		 */
		System.out.println("-------------------------");
		String Servlet_name = config.getServletName();//获取servlet的name
		System.out.println("Servlet_name："+Servlet_name);
		System.out.println("-------------------------");
		String v1 = config.getInitParameter("p1");
		System.out.println(v1);
		String v2 = config.getInitParameter("p2");
		System.out.println(v2);
		System.out.println("-------------------------");
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()) {
			String element = names.nextElement();
			System.out.println(element);
		}
		System.out.println("-------------------------");
//		ServletContext application = this.getServletContext();
		ServletContext application = config.getServletContext();
//		ServletContext application = this.getServletConfig().getServletContext(); 
		String ServletContext_value1 = application.getInitParameter("ServletContext_name1");
		System.out.println(ServletContext_value1);
		String ServletContext_value2 = application.getInitParameter("ServletContext_name2");
		System.out.println(ServletContext_value2);
		System.out.println("-------------------------");
		Enumeration<String> ServletContext_names = application.getInitParameterNames();
	    while(ServletContext_names.hasMoreElements()) {
	    	String element = ServletContext_names.nextElement();
	    	System.out.println(element);
	    }
	    System.out.println("-------------------------");
	    this.sconfig = config;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	@Override
	public ServletConfig getServletConfig() {
		
		return this.sconfig;
	}
	@Override
	public ServletContext getServletContext() {
		
		return sconfig.getServletContext();
	}
}
