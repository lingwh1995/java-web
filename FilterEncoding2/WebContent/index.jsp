<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="${pageContext.request.contextPath }/EncodingServlet?username=张三">测试GET请求乱码</a></h1>
	<form action="${pageContext.request.contextPath }/EncodingServlet" method="post">
		用户名:<input type="text" name="username" value="李四"/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>