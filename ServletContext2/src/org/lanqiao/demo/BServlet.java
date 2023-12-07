package org.lanqiao.demo;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BServlet
 */
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 演示从ServletContext中获取数据
	 */
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	* 1.获取ServletContext对象
	* 2.调用其getAttribute()方法完成获取数据
	*/		
	ServletContext application = this.getServletConfig().getServletContext();
	String name = (String)application.getAttribute("name");
	System.out.println(name);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
