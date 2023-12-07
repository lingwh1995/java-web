<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/AddStudentServlet'/>">
		学号：<input name="stuNo"/><br/>
		姓名：<input name="stuName"/><br/>
		年龄：<input name="stuAge"/><br/>
		<input type="submit" value="增加"/><br/>
	</form>
</body>
</html>