<%@page import="org.lanqiao.javabean_bingding.listener.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//javabean和session的绑定
		session.setAttribute("p", new Person(1,"tom"));
		//javabean和session的解除绑定(把Person对象从Session中移除)
		session.removeAttribute("p");
	%>
</body>
</html>