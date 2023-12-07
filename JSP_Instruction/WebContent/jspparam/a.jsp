<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>a.jsp演示jsp:param</h1>
	<h1>jsp:param:作为jsp:forward和jsp:include的参数来使用</h1>
	<jsp:forward page="b.jsp">
		<jsp:param value="zhangsan" name="username"/>
		<jsp:param value="123" name="password"/>
	</jsp:forward>
</body>
</html>