<%@ page language="java" import="org.lanqiao.demo.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user1" class="org.lanqiao.demo.User" scope="page"/>
	<jsp:useBean id="user2" class="org.lanqiao.demo.User" scope="request"/>
	<jsp:useBean id="user3" class="org.lanqiao.demo.User" scope="session"/>
	<jsp:useBean id="user4" class="org.lanqiao.demo.User" scope="application"/>
	${pageScope.user1 }<br />
	${requestScope.user2 }<br />
	${sessionScope.user3 }<br />
	${applicationScope.user4 }<br />
	
</body>
</html>