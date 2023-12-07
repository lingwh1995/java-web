package org.lanqiao.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 本类演示统计往网站访问量
 * Servlet的上下文环境,一般把名称命名为application,这个是由服务器创建的,在创建servlet的同时也创建了它
 * 获取ServletContext的两种方法：
 * 1.this.getServletContext();
 * 2.直接:getServletContext();
 * 3.通过servletConfig();获取
 *
 */
public class CountDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.尝试从ServletContext获取count属性
		 * 2.如果可以获取到count，则说明不是第一次访问了，count++,如果获取不到count，则说明是第一次访问，设置count值为1
		 */
		ServletContext app = this.getServletContext();
		Integer count = (Integer)app.getAttribute("count");
		if(count==null) {
			app.setAttribute("count", 1);
		}else {
			//app.setAttribute("count", ++count);
			app.setAttribute("count", count+1);
			//注意：这里是count+1或者++count，而不是count++
		}
		PrintWriter out = response.getWriter();
		if(count==null) {			
			out.write("<h1>1</h1>");
		}else {
			out.write("<h1>"+count+"</h1>");			
		}
	}
}
