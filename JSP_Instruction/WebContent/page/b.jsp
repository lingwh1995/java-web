<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//方式一：
		//演示errorPage指令，在page指令中指定errorPage的url即可
		int i = 10/0;  
		//地址栏未发生变化，说明是请求转发
		
		//方式二：
		//在xml中配置
		/*
		 <error-page>
		  	 <error-code>500</error-code>
		  	 <location>/page/errorPage.jsp</location>
	     </error-page>
		*/
		//详见b.jsp
	%>
</body>
</html>