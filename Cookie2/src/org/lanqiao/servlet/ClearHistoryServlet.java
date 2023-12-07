package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 技术分析:
 *	cookie.setMaxAge(0)
 *	步骤分析:
 *		1.在浏览器记录中添加一个超链接 
 *			<a href="/项目名/clearHistroy">清空</a>
 *		2.创建servlet clearHistroy
 *			创建一个cookie 
 *				名称路径保持一致
 *				setMaxAge(0)
 *			写回浏览器
 *		3.页面跳转
 *			重定向 product_list.jsp
 * @author ronin
 *
 */
public class ClearHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//创建一个cookie 
		Cookie cookie = new Cookie("ids","");
		cookie.setPath(request.getContextPath()+"/");
		//设置Cookie生命时长为0
		cookie.setMaxAge(0);
		//回写浏览器
		response.addCookie(cookie);
		//页面跳转
		response.sendRedirect(request.getContextPath()+"/product_list.jsp");
	}

}