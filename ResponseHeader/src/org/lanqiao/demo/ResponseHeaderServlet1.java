package org.lanqiao.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseHeaderServlet1
 */
public class ResponseHeaderServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//响应头的本质为一个键值对，可能存在一个头(一个名称一个值)，也可能存在一个头(一个名称多个值)
		response.setHeader("aaa", "AAA");
		//告诉浏览器，服务器发送给浏览器的内容的长度为多少
//		response.setIntHeader("Content-Length", 8888);
		//设置页面过期时间的头
//		response.setDateHeader("expires", 1000*5);
	}

}
