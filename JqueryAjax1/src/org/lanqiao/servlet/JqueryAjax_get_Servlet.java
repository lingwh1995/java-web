package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示jquery的$.get()方式发送ajax请求
 * @author ronin
 *
 */
public class JqueryAjax_get_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		System.out.println(username);
		System.out.println("请求方式为:"+request.getMethod());
		response.getWriter().print("这是对jquery的$.get()方法的ajax请求做出的响应...");
	}
}
