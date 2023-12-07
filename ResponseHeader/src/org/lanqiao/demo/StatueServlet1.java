package org.lanqiao.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatueServlet1
 */
public class StatueServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//与响应有关的有response
		//repose可以用来设置状态码
//		response.sendError(404);
//		response.sendError(404,"您访问的资源存在，就不给您看！");
		response.sendError(500);
		PrintWriter out = response.getWriter();
		out.print("<h1>Hello World</h1>");
		/*
		 * 通过设置状态码可以模拟404，500等所有的错误
		 */
//		response.setStatus(200);//用来发送成功的状态码
		
	}

}
