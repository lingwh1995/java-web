<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>演示JSP静态包含</h1>
	<%
		String name = "张三";
		/*
			静态包含和动态包含的区别：静态包含编译后生成一个.class文件
			动态包含编译后生成两个.class文件(之后合并服务器响应给浏览器的内容)
		*/
		/*
		静态包含作用：提高页面可重用性
		*/
	%>
	<%@ include file="lo.jsp" %>
</body>
</html>