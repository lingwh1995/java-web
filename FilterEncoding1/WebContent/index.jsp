<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Filter全站统一字符编码:解决乱码问题</h1>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
		<input type="text" name="username"/><br />
		<input type="text" name="password"/><br />
		<input type="submit" value="提交"/><br />
	</form>
</body>
</html>