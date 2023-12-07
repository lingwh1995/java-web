<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>演示JSP内置对象Cookie</title>
</head>
<body>
	<h1>获取所有Cookie</h1>
	<!-- 
		通过${cookie}获取map{key=Cookie},相当于map的key是cookie的键
		pageContext:获取的不是map集合，相当于pageContext内置对象
		在JSP页面中获取项目名称
	 -->
	${cookie }
	<hr />
	<h1>获取指定名称的Cookie的值</h1>
	${cookie.username.value }
	<h1>在JSP中获取项目名称</h1>
	${pageContext.request.contextPath }
</body>
</html>