<%@page import="org.lanqiao.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL执行运算(四则运算、逻辑运算、三元运算)</title>
</head>
<body>
	<%
		request.setAttribute("i", 3);
		request.setAttribute("j", 4);
		request.setAttribute("q", "12");
		request.setAttribute("k", "k");
	%>
	四则运算(i+j):${i+j } <br />
	<!-- 注意:q为字符串类型的数据, -->
	四则运算(i+q):${i+q } <br />
	<!-- 这个会发生异常,+:只能进行加法运算，字符串形式数组可以进行加法运算 -->
	<%-- 四则运算(i+k):${i+k }  --%> <br />
	
	<hr />
	
	<h1>判断一个容器的长度是否否为0(array、list、set、map),还可以判断一个对象是否为空 </h1>
	<%
		List list1 = null;
		request.setAttribute("list1", list1);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("Hello");
		list2.add("World");
		list2.add("Java");
		request.setAttribute("list2", list2);
	%>
	empty用法(判断长度是否为0):${empty list1} <br /><!-- 值为布尔值 -->
	empty用法(判断长度是否为0):${empty list2} <br />
	
	<hr />
	
	<%
		User user = new User();
		request.setAttribute("user", user);
	%>
	<h1>判断域中的bean是否为空</h1>
	域中的bean是否为空:${empty user} <br />
	域中的bean是否为空:${empty user_} 
	
	<h1>EL执行逻辑运算</h1>
	判断3是否大于4:${3>4}
	
	<h1>EL执行三元运算</h1>
	${3>4?"大于":"小于" }
</body>
</html>