<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>GET请求</h1>
	<form action="/CZ_PageEncoding/AServlet" method="get">
		用户名：<input type="text" name="username" value="">
			  <input type="submit"  value="提交">
	</form>
	<hr />
	<h1>POST请求</h1>
	<form action="/CZ_PageEncoding/AServlet" method="post">
		用户名：<input type="text" name="username" value="">
			  <input type="submit"  value="提交">
	</form>
</body>
</html>