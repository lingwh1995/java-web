<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		window.onload = function(){
			//以UTF-8编码解码后台传过来的汉字
			var s = "${cookie.savename.value }";
			s = decodeURI(s);
			//alert(s);
			//把Cookie的值赋值给name属性值为username的表单
			document.getElementsByName("username")[0].value = s ;
		}
	</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/LoginServlet">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" value="username"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="saveName" value="ok">记住用户名</td>
				<td><input type="checkbox" name="autologin" value="ok">自动登录</td>
			</tr>
			<tr>
				<td colSpan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>