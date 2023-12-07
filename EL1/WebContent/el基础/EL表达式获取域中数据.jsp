<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr />
	<h1>EL表达式获取域中数据:获取简单数据</h1>
	
	<%
		//EL表达式全域查找的特点：范围从小到大
		pageContext.setAttribute("xxx", "pageContext");
		request.setAttribute("xxx", "request");
		session.setAttribute("xxx", "session");
		application.setAttribute("xxx", "application");
		//注意：在session存储数据后，如果没杀死session不，即使注释掉了，数据还是存放在session中
	%>
		EL表达式全域查找(查找成功):${xxx} <br /><%-- 全域查找，如果不存在，输出空字符串，而不是null--%>
		EL表达式全域查找(查找为空):${hello} <br /><%-- 全域查找，如果不存在，输出空字符串，而不是null--%>
		获取pageContext域中的数据:${pageScope.xxx} <br />
		获取request域中的数据:${requestScope.xxx} <br />
		获取session域中的数据:${sessionScope.xxx} <br />
		获取application域中的数据:${applicationScope.xxx} <br />
		<%--注意：是sessionScope.xxx不是session.xxx --%>
		
	<hr />
	
	
	
	<h1>EL表达式全域查找为空和JSP输出语句全域查找为空的不同</h1>
		EL表达式全域查找(查找成功):---${xxx}=== <br /><%-- 全域查找，如果不存在，输出空字符串，而不是null--%>
		EL表达式全域查找(查找为空):---${hello}=== <br /><%-- 全域查找，如果不存在，输出空字符串，而不是null--%>
		<%="JSP输出语句全域查找(查找成功):---"+pageContext.findAttribute("xxx")+"==="%> <br />
		<%="JSP输出语句全域查找(查找失败):---"+pageContext.findAttribute("hello")+"==="%>
		<!-- 
			EL表达式全域查找为空和JSP输出语句全域查找为空的不同:
			1.EL表达式全域查找如果为空则输出:空字符串(页面效果是什么都不显示)
			2.JSP输出语句全域查找如果为空则显示:null
			
			
			补充:
			1.EL表达式的全域查找底层调用的是pageContext对象的findAttribute()方法，所以:使用EL表达式时如果没有没有限制域的范围,如:${xxx},则默认按照
			2.使用EL表达式不需要引入任何第三方类库，直接就可以在JSP页面中使用
			3.使用EL表达式取值的时候，EL表达式不能书写在Java代码中
			4.EL表示默认搜索范围是从小范围到大范围
		 -->
		 
	<hr />
	
	
	<h1>EL表达式获取域中数据和JSP获取域中数据:获取复杂数据结构中的简单类型数据</h1>
	<%-- 
		EL表达式获取域中数据有两种方法:
			1.${对象.属性 } 
			2.${对象.get("属性")}
	--%>
	<%
		//往request域中放入数组
		request.setAttribute("arr", new String[]{"hello","world","java"});
	%>
	<h2>获取数组中的数据(数组中存放简单类型的数据)</h2>
	EL表达式获取域中数组中的数据:${requestScope.arr[0] }---${arr[1] }---${arr[2] } <br />
	<!-- 注意:JSP方式获取到的域中的数据是Object类型,需要强转,如下面的的将Object类型数据转换为String[]类型数据 -->
	JSP获取域中数组中的数据:<%=((String[])request.getAttribute("arr"))[0] +"---"+((String[])request.getAttribute("arr"))[1]+"---"+((String[])request.getAttribute("arr"))[2]%>
	
	
	<%
		//往request域中放入List集合
		List<String> list = new ArrayList<String>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("wangwu");
		request.setAttribute("list", list);
	%>
	<h2>获取List集合中的数据(List集合中存放简单类型的数据)</h2>
	EL表达式获取域中List集合中的数据:${requestScope.list}} <br />
	EL表达式获取域中List集合中的数据:${requestScope.list[0]}---${list[1] }---${list[2] } <br />
	<!-- 注意:JSP方式获取到的域中的数据是Object类型,需要强转,如下面的的将Object类型数据转换为List类型数据 -->
	JSP获取域中List集合中的数据:<%=((List)request.getAttribute("list")).get(0)+"---"+((List)request.getAttribute("list")).get(1)+"---"+((List)request.getAttribute("list")).get(2)%>
	
	
	<%
		//往request域中放入Map集合
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","tom");
		map.put("age","18");
		request.setAttribute("map", map);
	%>
	<h2>获取Map集合中的数据</h2>
	EL表达式获取域中Map集合中的数据:${requestScope.map} <br />
	EL表达式获取域中Map集合中的数据:${map.name}---${map.age} <br />
	EL表达式获取域中Map集合中的数据:${map.get("name")}---${map.get("age")} <br /><!-- xxx.get("key")为map特有取值方式,不适用于获取对象中的属性值 -->
	<!-- 注意:JSP方式获取到的域中的数据是Object类型,需要强转,如下面的的将Object类型数据转换为Map类型数据 -->
	JSP获取域中Map集合中的数据:<%=((Map)request.getAttribute("map")).get("name")+"---"+((Map)request.getAttribute("map")).get("age")%>
	
	<hr />
	<h1>EL表达式获取欲中特殊名称的数据(EL表达式转意)</h1>
	<%
		//往request域中放一个特殊名称的数据
		request.setAttribute("arr.age", "只有当转义成功,才能看到我.....");
	%>
	<h2>获取域中特殊名称的数据(数据名称中含有特殊符号: . + 等)</h2>
	<!-- 格式:	${作用域范围["数据名称"]} -->
	获取域中特殊名称的数据:${requestScope["arr.age"] }
	
	<hr />
</body>
</html>