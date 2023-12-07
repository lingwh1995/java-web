<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 接收来自form.jsp这个页面的值 -->
	<%--
		 这里需要使用jsp动作标签，如下所示: 
	--%>
	
	<!-- 接受值 -->
	<jsp:useBean id="u" class="org.lanqiao.entity.User"></jsp:useBean>
	<!-- 上面的代码作用等同于:	User user = new User(); -->
	<jsp:setProperty property="username" name="u"/>
	<jsp:setProperty property="password" name="u"/>
	
	<!-- 打印值 -->
	<jsp:getProperty property="username" name="u"/>
	<jsp:getProperty property="password" name="u"/>
	login.jsp
</body>
</html>