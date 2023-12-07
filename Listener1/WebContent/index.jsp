<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="${pageContext.request.contextPath }/live/request.jsp">演示request的创建和销毁</a></h1>
	<h1><a href="${pageContext.request.contextPath }/live/session.jsp">演示sesssion的创建和销毁</a></h1>
	<h1><a href="${pageContext.request.contextPath }/attr/attr.jsp">监听ServletContext/application(jsp)中属性的状态的变化</a></h1>
	<h1><a href="${pageContext.request.contextPath }/javabean和session的绑定和解绑/session_bingding.jsp">监听JavaBena和Session的绑定(把JavaBean放到Session中)和解绑(把JavaBean从Session中移除)</a></h1>
</body>
</html>