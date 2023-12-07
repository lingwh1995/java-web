package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示jquery的$.ajax()方式发送ajax请求
 * @author ronin
 *
 */
public class JqueryAjax_ajax_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		System.out.println(username);
		//通过load方法发送请求,若参数形式为正常形式,则请求为为get请求,若参数形式为json格式数据则请求方式为post方式
		System.out.println("请求方式为:"+request.getMethod());
		//response.getWriter().print("这是对jquery的load方法的ajax请求做出的响应...");
		
		//向前台传递json格式的数据
		String s = "{\"a\":\"$.ajax()\"}";
		response.getWriter().print(s);
	}

}
