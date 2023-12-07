<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cookie入门(利用Cookie完成会话跟踪技术)</h1>
	<hr />
	<h1>保存Cookie</h1>
	<%	
		//构造Cookie对象
		Cookie cookie1 = new Cookie("aaa","AAA");
		Cookie cookie2 = new Cookie("bbb","BBB");
		//服务器添加Cookie
		response.addCookie(cookie1);
		response.addCookie(cookie2);
	%>
</body>
</html>