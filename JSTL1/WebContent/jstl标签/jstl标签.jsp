<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr />
	
	<h1>1.c:if标签</h1>
	<c:if test="${3>4}">
		3大于4
	</c:if>
	
	<c:if test="${3<=4 }">
		3小于等于4
	</c:if>
	
	<hr />
	
	<h1>2.c:forEach标签</h1>
	<h2>循环输出1~10</h2>
	<c:forEach begin="1" end="10" step="1" var="i">
		${i }<br />
	</c:forEach>
	
	<h2>循环输出1~20</h2>
	<c:forEach begin="1" end="20" step="2" var="i" varStatus="vs">
	<!-- vs.current:记录循环状态
			 count:记录次数
			 current:当前遍历的内容
	 -->
		${i }---${vs.count}---${vs.current}<br />
	</c:forEach>
	<hr />
	<h2>循环获取list中的元素</h2>
	<% 
		//给域中放一个list
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		list.add("java");
		request.setAttribute("list", list);
	%>
	<c:forEach items="${list }" var="l">
		${l }<br />
	</c:forEach>
	
	<hr />
	
	<h2>循环获取set中的元素</h2>
	<% 
		//给域中放一个set
		Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		request.setAttribute("set", set);
	%>
	<c:forEach items="${set }" var="s">
		${s }<br />
	</c:forEach>
	
	
	<h2>循环获取map中的元素</h2>
	<% 
		//给域中放一个map
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1,"a");
		map.put(2,"b");
		map.put(3,"c");
		request.setAttribute("map", map);
	%>
	<h2>获取map中的元素,方式一: </h2>
	<c:forEach items="${map }" var="m">
		获取map:${m }---获取key:${m.key }--获取value:${m.value }<br />
	</c:forEach>
	
	<h1>c:set 往域中设置值的</h1>
	
	<%-- 往page域中设置值 --%>
	<c:set var="pageKey" value="pageValue" scope="page"/>
	取出page域中的值:<c:out value="${pageScope.pageKey }"/><br />
	
	<%--往request域中设置值  --%>
	<c:set var="requestKey" value="requestValue" scope="request"/>
	取出request域中的值:<c:out value="${requestScope.requestKey }"/><br />
	
	<%-- 往session域中设置值 --%>
	<c:set var="sessionKey" value="sessionValue" scope="session"/>
	取出session域中的值:<c:out value="${sessionScope.sessionKey }"/><br />
	
	<%-- 往application域中设置值 --%>
	<c:set var="applicationKey" value="applicationValue" scope="application"/>
	取出application域中的值:<c:out value="${applicationScope.applicationKey }"/><br />
	
	<h1>c:choose</h1>
	<c:set var="day" value="3" scope="request"/><!-- 相当于request.setAttribute("day",3);-->
	<c:choose>
		<c:when test="${day==1}">
			周一
		</c:when>
		<c:when test="${day==2}">
			周二
		</c:when>
		<c:when test="${day==3}">
			周三
		</c:when>
		<c:when test="${day==4}">
			周四
		</c:when>
		<c:otherwise>
			其他
		</c:otherwise>
	</c:choose>
</body>
</html>