<%@page import="org.lanqiao.entity.User"%>
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
		User user = new User("001","zs","123");
		//将user放入域中
		request.setAttribute("user", user);
	%>
	<h1>获取bean中的id值</h1>
	老方式:<%=((User)request.getAttribute("user")).getId() %><br />
	<!-- 若是对象.属性则可以取值,如:user.name	若是对象.字段则不能取值,如:user.username -->
	EL方式:${user.id }---${user.name }---${user.password }
	
</body>
</html>