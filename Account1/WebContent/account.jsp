<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/AccountServlet">
		<table border="1">
			<tr>
				<td>转出方</td>
				<td><input type="text" name="fromuser"></td>
			</tr>
			<tr>
				<td>转入方</td>
				<td><input type="text" name="touser"></td>
			</tr>
			<tr>
				<td>转账金额</td>
				<td><input type="text" name="money"></td>
			</tr>
			<tr>
				<td colSpan="2" align="center"><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>