<%@page import="org.lanqiao.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式内置对象_总共11个</title>
<h1>配TestEl_innerObject.jsp观察效果</h1>
</head>
<body>
	<!-- 
		ELE的11个内置对象:
		pageScope
		requestScope
		sessionScope
		applicationScope
		
		关于以上四个,要注意的是:
			1.request和requsetScope是两个不同的对象,request、session、servletContext等需要通过pageContext来获取
			2.pageScope等是EL的内置对象,request等是JSP内置对象,是有区别的。
		
		
		
		
		param
		paramValues
		
		header
		headerValues
		
		initParam
		
		Cookie
		pageContext
		注意:除了pageContext其余对象获取的全是map集合
	 -->
	 <a href="innerObject_params.jsp?username=tom&password=123&hobby=sleeep">和参数相关的内置对象</a><br />
	 <a href="innerObject_header.jsp">和请求头相关的内置对象</a><br />
	 <a href="innerObject_initparams.jsp">和全局的初始化参数相关的内置对象</a><br />
	 <% 
	 	Cookie cookie = new Cookie("username","tomcat");
	 	response.addCookie(cookie);
	 %>
	 <a href="innerObject_cookie.jsp">和Cookie相关的内置对象</a><br />
</body>
</html>