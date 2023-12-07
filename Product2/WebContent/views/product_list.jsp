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
	<table border="1" cellSpacing="0" align="center" width="80%">
		<tr> 
			<th>商品编号</th>
			<th>商品图片</th>
			<th>商品名称</th>
			<th>市场价</th>
			<th>商城价</th>
			<th>商品描述</th>
			<th>操作</th>
		</tr> 
		<c:forEach items="${productList }" var="p">
			<tr>
				<td width="6%">${p.pid }</td>
				<td width="6%"><img src="${pageContext.request.contextPath }/${p.pimage }" width="80px"/></td>
				<td width="6%">${p.pname }</td>
				<td width="6%">${p.market_price }</td>
				<td width="6%">${p.shop_price }</td>
				<td >${p.pdesc }</td>
				<td width="6%">
					修改|删除
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>