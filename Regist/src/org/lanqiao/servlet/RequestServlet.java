package org.lanqiao.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ---------------------------------------------------------------------
 * request操作请求行的常用方法:
 * 掌握
 * 		String getMethod():获取请求方式
 *		String getRemoteAddr():获取ip地址
 *	 	String getContextPath() :在java中获取项目名称  (/day10)
 *  
 * 了解
 *		getRequestURI():获取的是 从项目名到参数之前的内容  /day10/regist
 *  	String getQueryString():get请求的所有参数   username=tom&password=123
 *		String getProtocol():获取协议和版本
 * ---------------------------------------------------------------------
 * request操作请求头的常用方法:
 * 掌握
 *		String getHeader(String key):通过key获取指定的value (一个)
 *		String getHeader("user-agent"):获取浏览器信息	
 *		String getHeader("referer"):获取referer
 * 了解
 *		Enumeration getHeaders(String name) :通过key获取指定的value(多个)
 *		Enumeration getHeaderNames() :获取所有的请求头的名称
 *		int getIntHeader(String key):获取整型的请求头
 *		long getDateHeader(String key):获取时间的请求头
 * 重要的请求头
 *		user-agent:浏览器内核 msie firefox chrome
 *		referer:页面从那里来 防盗链
 * ---------------------------------------------------------------------
 *  request获取请求参数常用方法:
 *  	注意:
 *  		1.get请求参数是放在地址栏中的,post请求点的请求参数是放在请求体中的
 *  		2.请求参数key-value形式的
 *  重要
 *  	String getParameter(String key):获取一个值
 * 		String[] getParameterValues(String key):通过一个key获取多个值
 * 		Map<String,String[]> getParameterMap():获取所有的参数名称和值
 * ---------------------------------------------------------------------
 * @author ronin
 *
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("------------------request操作请求行----------------------");
		//重要方法
		//String getMethod():获取请求方式
		System.out.println("请求方式:"+request.getMethod());
		//String getRemoteAddr():获取ip地址
		System.out.println("客户端IP地址:"+request.getRemoteAddr());
		//String getContextPath() :在java中获取项目名称
		System.out.println("项目名称:"+request.getContextPath());
		
		
		//了解方法
		//getRequestURI():获取的是 从项目名到参数之前的内容 
		System.out.println("URI:"+request.getRequestURI());
		//getRequestURL():地址栏信息
		System.out.println("URL:"+request.getRequestURL());
		//String getProtocol():获取协议和版本
		System.out.println("协议版本:"+request.getProtocol());
		//String getQueryString():get请求的所有参数   username=tom&password=123
		System.out.println("所有请求参数:"+request.getQueryString());
		System.out.println("所有请求参数:"+request.getQueryString().getClass().getName());
		System.out.println("------------------request操作请求行----------------------");
		
		
		System.out.println("------------------request操作请求头----------------------");
		//获取浏览器信息
		System.out.println("user-agent:"+request.getHeader("user-agent"));
		//获取referer(页面来源)
		//System.out.println("referer:"+request.getHeader("referer"));
		String referer = request.getHeader("referer");
		if(referer==null) {
			System.out.println("从地址栏输入的...");
		}else if(referer.contains("localhost")) {
			System.out.println("自己点的...");
		}else if(referer.contains("192.168.")) {
			System.out.println("局域网内其他人点的...");
		}else {
			System.out.println("盗链的人点的...");
		}
		System.out.println("------------------request操作请求头----------------------");
		
		
		System.out.println("-----------------request获取请求参数---------------------");
		/*
		String getParameter(String key):获取一个值
		 * 		String[] getParameterValues(String key):通过一个key获取多个值
		 * 		Map<String,String[]> getParameterMap():获取所有的参数名称和值
		 * */
		//String getParameter(String key):获取一个值
		String username = request.getParameter("username");
		//String[] getParameterValues(String key):通过一个key获取多个值
		String[] genders = request.getParameterValues("gender");
		System.out.println("获取来自checkbox的多个请求参数:"+Arrays.toString(genders));
		String[] parameters = request.getParameterValues("parmas");
		System.out.println("获取来自超链接多个请求参数:"+Arrays.toString(parameters));
		//获取所有参数的key(返回值为老版本的迭代器)
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String element = parameterNames.nextElement();
			System.out.print(element+"\t");
			System.out.println("\n");
		}
		//Map<String,String[]> getParameterMap():获取所有的参数名称和值(key为表单中name的值,value为用户输入的值)
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<String> keySet = parameterMap.keySet();
		for(String key:keySet){
			String[] value = parameterMap.get(key);
			System.out.print(key+"----"+Arrays.toString(value)+"\t");
		}
		System.out.println("-----------------request获取请求参数---------------------");
	}

}