<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center" width="20%">
		<tr>
			<th>商品名称</th>
			<th>商品数量</th>
		</tr>
		<% 
			//1.获取购物车
			Map<String,Integer> map = (Map<String,Integer>)session.getAttribute("cart");
			//2.判断购物车是否为空
			if(map==null){
				//若为空，提示:购物车为空,先去逛逛~~
				out.print("<tr><td colspan='2'>购物车为空,先去逛逛~~</td></tr>");
			}else{
				//若不为空，遍历购物车
				for(String name:map.keySet()){
					out.print("<tr>");
					
					out.print("<td>");
					//获取货物名称
					out.print(name);
					out.print("</td>");
					
					out.print("<td>");
					//获取货物数量
					out.print(map.get(name));
					out.print("</td>");
					
					out.print("</tr>");
				}
			}
		%>
	</table>
	<hr />
	<a href="product_list.jsp">继续购物</a><br />
	<a href="/Session1/ClearCart">清空购物车</a><br />
</body>
</html>