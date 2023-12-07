package org.lanqiao.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示处理乱码
 * 乱码分为request乱码处理和response乱码处理
 */
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get方式处理response乱码：服务器发送给浏览器的内容的乱码的处理
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("username");
		//get方式处理request处理乱码要采用回退重新编码的方式
		byte[] bs = name.getBytes("ISO-8859-1");
		String username = new String(bs,"utf-8");
		System.out.println(username);	
		PrintWriter out = response.getWriter();
		out.print(username);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理request乱码：即用户输入的内容传输到后台的时候的乱码的处理
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println(username);
		//处理response乱码：服务器发送给浏览器的内容的乱码的处理，一句顶两句
		response.setContentType("text/html;charset=utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("你好post");
		
		//这里为演示方便，注意：一般情况下处理乱码要写在最开始
	}

}
