<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>哈哈，错误了~~</h1>
	<%
		//在page指令中设置isErrorPage="true"，说明指定了当前页面为处理错误的页面，状态码为500，不指定状态码为200
		//只有这个页面可以使用exception这个内置对象
		exception.printStackTrace(response.getWriter());
	%>
</body>
</html>