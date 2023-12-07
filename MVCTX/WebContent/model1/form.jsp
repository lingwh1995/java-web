
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 点击提交之后到达login.jsp这个页面，然后获取提交过去的数据 -->
	<form method="post" action="${pageContext.request.contextPath }/model1/login.jsp">
		<table border="1" align="center">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colSpan="2" align="center"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>