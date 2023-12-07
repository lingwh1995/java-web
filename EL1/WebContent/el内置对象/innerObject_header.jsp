<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>测试和请求头相关的信息</h1>
	${header}
	<hr />
	${headerValues}
	<hr />
	<h1>获取常见的请求头</h1>
	referer:${header.referer }<br />
	user-agent:${headerValues["user-agent"][0]}<br />
</body>
</html>