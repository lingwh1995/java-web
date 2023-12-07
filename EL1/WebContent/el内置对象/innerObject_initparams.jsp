<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>i全局的初始化参数相关的内置对象</title>
</head>
<body>
	<h1>获取全局的初始化参数</h1>
	<!-- 通过Web.xml中的<param-name>获取<Context-param>中<param-value>值 -->
	${initParam.encoding }
</body>
</html>