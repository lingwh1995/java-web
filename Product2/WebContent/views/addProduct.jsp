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
	<%
		//获取令牌(随机码)
		String code = CommonUtils.getRandomCode();
		//把令牌(随机码)放入 session域中
		session.setAttribute("session_lingpai", code);
		
		//把令牌(随机码)放入 page域中,这样通过el表达式就可以在 当前域获取这个code,并把值作为隐藏域的value传递过去
		pageContext.setAttribute("r_code", code);
	%>
	<form method="post" action="${pageContext.request.contextPath }/AddProductServlet">
		<input type="hidden" name="r_lingpai" value="${pageScope.r_code }"/>
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