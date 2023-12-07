<%@page import="org.lanqiao.utils.CommonUtils"%>
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
	<form method="post" action="${pageContext.request.contextPath }/AddProductServlet">
		<table border="1" cellSpacing="0" align="center" width="20%">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="pname"></td>
			</tr>
			<tr>
				<td>市场价</td>
				<td><input type="text" name="market_price"></td>
			</tr>
			<tr>
				<td>商城价</td>
				<td><input type="text" name="shop_price"></td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td><input type="text" name="pdesc"></td>
			</tr>
			<tr>
				<td colSpan="2" align="center"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>

</body>
</html>