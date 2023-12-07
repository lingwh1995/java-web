<%@ page language="java" import="org.lanqiao.demo.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<hr />
	<% 
		request.setAttribute("value", "request");
		session.setAttribute("value", "session");
	%> 
	<h5>测试requestScope和sessionScope</h5>
		${requestScope.value }<br />
		${sessionScope.value }
	<hr />
	<h4>c:set用于取值，c:out用于赋值</h4>
	<c:set var="myvar" value="myvalue"/>
	<%-- pageScope:页面范围--%>
	myvar:<c:out value="${pageScope.myvar} "/>
	<hr />
	<h4>c:if用于判断</h4>
	<c:if test="${pageScope.myvar=='myvalue' }">
		<c:out value="true"/>
	</c:if>
	<hr />
	<c:set var="mydata" value="This is value you need"/>
	<c:if test="${pageScope.mydata=='This is value you need' }">
		<c:out value="true"/>
	</c:if>
	<p>注意：在JSTL中，只有c:if，没有c:else</p>
	<%
		//放置简单数据
		request.setAttribute("name", "request");
		session.setAttribute("name", "session");
		//放置对象类型的数据
		User u1 = new User(1,"zhangsan");
		request.setAttribute("user", u1);
		//获取含有对象的对象
		Address address = new Address("西安","长安");
		u1.setAddress(address);
		//获取List集合元素
		List<User> list = new ArrayList<User>();
		User u2 = new User(2,"lisi");
		User u3 = new User(3,"wangwu");
		User u4 = new User(4,"zhaoliu");
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		request.setAttribute("list", list);
		//获取Map集合中的数据
		Map<String,User> map = new HashMap<String,User>();
		map.put("u1",u1);
		map.put("u2",u2);
		map.put("3",u3);
		map.put("4",u4);
		session.setAttribute("map", map);
		//综合练习，获取Map集合中的List集合
		Map<String,List<User>> ulistMap = new HashMap<String,List<User>>();
		ulistMap.put("1", list);
		request.setAttribute("ulistMap", ulistMap);
	%>
	<h4>获取List集合中的数据</h4>
	<c:forEach items="${list }" var="ele">
		<c:out value="${ele.id }"/> ----------<c:out value="${ele.name }"/><br />
	</c:forEach >
	<p>注意：forEach中要使用items属性和var属性</p>
	<hr />
	<h4>获取Map集合中的数据</h4>
	<c:forEach items="${map}" var="ele">
		id:${ele.value.id }----------name:${ele.value.name }<br />
	</c:forEach>
	<p>注意：获取map中的数据要通过value属性获取</p>
	<hr />
	
</body>
</html>