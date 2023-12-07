<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP获取参数(之前可以在Servlet中获取，现在需要在JSP中获取)</h1>
	<h2>获取单个参数</h2>
	获取单个参数(username):${param.name }<br />
	获取单个参数(password):${param.password }<br />
	<h2>获取多个参数</h2>
	获取单个参数(所有的参数):${paramValues }<br />
	获取单个参数(所有的参数):${paramValues.username[0] }<br />
	获取单个参数(所有的参数):${paramValues.password[0] }<br />
</body>
</html>