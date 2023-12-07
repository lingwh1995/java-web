package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AServlet
 */
public class AjaxServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("Medhtod:-----get<br />");
		//get方式:前台不传递任何参数
		//System.out.println("Hello World");
		response.getWriter().print("Hello AJAX!!!");
		
		
		//get方式:前台传递参数username和pwd
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		//System.out.println("ajax_get接收来自前台的参数:"+username+"--"+pwd);
		response.getWriter().print("ajax_get接收来自前台的参数:"+username+"--"+pwd);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("Medhtod:-----post<br />");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);
		response.getWriter().print("ajax_post接收来自前台的参数:"+username+"--"+pwd);
	}
}