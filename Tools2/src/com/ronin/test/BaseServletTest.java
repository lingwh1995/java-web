package com.ronin.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ronin.servlet.BaseServlet;

/**
 * 演示BaseServlet
 * 		1.可以让一个Servlet有多个请求处理方法
 * 		2.简化了转发和重定向
 * 
 * 请求方法的格式:
 * 		public String regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			return null;
		}
	请求BaseServlet中的方法:
	http://localhost/Tools/BaseServletTest?method=regist
 * @author ronin
 *
 */
public class BaseServletTest extends BaseServlet {
	/*
	 * 访问这个Servlet中的regist方法:
	 * http://localhost/Tools/BaseServletTest?method=regist
	 */
	public String regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("regist...");
		return "/index.jsp";//表示转发到index.jsp
	}
	
	
	/*
	 * 访问这个Servlet中的regist方法:
	 * http://localhost/Tools/BaseServletTest?method=login
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login...");
		//return "f:/index.jsp";//f前缀表示转发
		//return "r:/index.jsp";//r前缀表示重定向
		//return "";//不转发也不重定向
		return null;//不转发也不重定向
		/**
		 * 注意:如果需要重定向到本项目之外的资源,如重定向到百度
		 * 		就要按照以下步骤来做了
		 * 		1.return null
		 * 		2.按照原来的的方法重定向
		 */
	}

}