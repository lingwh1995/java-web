<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//往applicatio/ServletContext域中添加一个属性
		application.setAttribute("username", "tom");
		//替换applicatio/ServletContext域中的一个属性
		application.setAttribute("username", "tom1");
		//删除applicatio/ServletContext域中的一个属性
		application.removeAttribute("username");
	%>
</body>
</html>