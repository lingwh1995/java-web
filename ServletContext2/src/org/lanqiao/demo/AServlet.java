package org.lanqiao.demo;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1.获取ServletContext对象
		 * 2.调用其setAttribute()方法完成保存数据
		 */
		
		//获取ServletContext的两种方法
//		ServletContext application = this.getServletContext();
		ServletContext application = this.getServletConfig().getServletContext();
		application.setAttribute("name", "张三");
	}
}
