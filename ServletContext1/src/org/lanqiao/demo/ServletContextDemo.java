package org.lanqiao.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletContext
 * 代表整个项目的引用,代表了当前的项目,一个项目中只有一个
 * 当项目启动的时候,服务器就为每一个web项目创建了一个servletContext对象
 * 当项目被移除的时候或者服务器关闭的时候ServletContext就被销毁了
 * 
 * 作用:
 * 		1.获取全局的初始参数
 * 		2.共享资源(xxxAttribute())
 * 获取ServletConfig的两种方法:
 * 		1.this.getServletConfig();
 * 		2.直接:getServletConfig();
 * 		3.通过servletConfig获取 getServletConfig().getServletContext()
 * 常用方法:
 * 		1.获取context-paramd的信息
 * 			getInitParameter();
 * 			getInitParameterNames() 
 * 		2.xxxAttriburte();
 * 		3.String getRealPath(String path):获取文件部署到Tomcat上的真实路径
 * 	 	4.InputStream getResourcesAsStream(String path):以流的方式返回一个文件
 *		5.Strnig getMimeType(String 文件名称):获取文件的mime类型	大类型/小类型 
 * @author ronin
 *
 */
public class ServletContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//获取ServletContext对象
		ServletContext application = this.getServletConfig().getServletContext();
		//获取web.xml中Context下的配置信息
			//根据参数名获取
		String user = application.getInitParameter("user");
		System.out.println(user);
		String password = application.getInitParameter("password");
		System.out.println(password);
			//获取所有的参数名
		Enumeration<String> names = application.getInitParameterNames();
		while(names.hasMoreElements()) {
			String param_name = names.nextElement();
			System.out.println("每一个参数名:"+param_name);
		}
		//获取文件真实路径
		String path1 = application.getRealPath("/");
		System.out.println(path1);
		String path2 = application.getRealPath("/a.txt");
		System.out.println(path2);
		String path3 = application.getRealPath("/b.txt");
		System.out.println(path3);
		//以流的方式返回一个文件
			//注意:只能获取b.txt的内容,不能获取a.txt的内容
		InputStream stream1 = application.getResourceAsStream("/a.txt");
		System.out.println(stream1);
		InputStream stream2 = application.getResourceAsStream("/b.txt");
		System.out.println(stream2);
		//获取文件的miem类型
		String type1 = application.getMimeType("a.txt");
		System.out.println(type1);
		String type2 = application.getMimeType("b.txt");
		System.out.println(type2);
	}

}
