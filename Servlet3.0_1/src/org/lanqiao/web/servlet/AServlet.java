package org.lanqiao.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示Servlet3.0使用注解访问Servlet
 * @author ronin
 *
 */
//@WebServlet(urlPatterns="/A")
@WebServlet(urlPatterns={"/A","/AA"},
		initParams={@WebInitParam(name="p1",value="v1"),@WebInitParam(name="p2",value="v2")})
public class AServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello servlet3.0");
		resp.getWriter().print("hello Servlet3.0");
		
		String value = this.getServletConfig().getInitParameter("p1");
		System.out.println("初始化参数的值:"+value);
	}
}
