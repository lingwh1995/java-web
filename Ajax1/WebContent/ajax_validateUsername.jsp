<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		/*
		使用AJAX验证用户名是否被注册
		*/
		function createXMLHttpRequest(){
			try {
				return new XMLHttpRequest();
			} catch (e) {
				try {
					return new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						return new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
						throw e;
					}
				}
			}
		}
		window.onload= function () {
			function $(id){return document.getElementById(id);}
			$("uname").onblur = function(){
				//获取异步对象
				var xmlHttpRequest = createXMLHttpRequest();
				//打开连接
				xmlHttpRequest.open("post","${pageContext.request.contextPath}/AjaxValidateUsernameServlet",true);
				//发送请求 				
				xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				xmlHttpRequest.send("username="+$("uname").value);
				//xmlHttpRequest.send("username=zs&pwd=123");
				//响应xmlHttpRequest对象的onreadystatechange()事件								
				xmlHttpRequest.onreadystatechange = function() {
					if(xmlHttpRequest.readyState ==4 && xmlHttpRequest.status ==200){
						var text = xmlHttpRequest.responseText;
						if(text==1){
							$("errorInfo").innerHTML = "该用户名已经被注册";
						}else{
							$("errorInfo").innerHTML = "该用户名可以使用";
						}
					}
				}
			}
	}
	</script>
</head>
<body>
	<h1>使用AJAX验证用户名是否被注册:输入--zs--出发onblur事件验证</h1>
	<form action="${pageContext.request.contextPath}/AjaxValidateUsernameServlet" method="post">
		用户名：<input type="text" name="username" id="uname"><span id="errorInfo"></span><br />
		密码：<input type="text" name="password"><br />
		<input type="submit" value="注册"/>
	</form>
</body>
</html>