<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		function $(id){return document.getElementById(id);}
		//创建XMLHttpRequest对象
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
		window.onload = function(){
			//失去请求:发送ajax请求
			$("username").onblur = function(){
				//1.创建(异步)核心对象
				var xmlHttpRequest = createXMLHttpRequest();
				//2.open(打开)链接
				xmlHttpRequest.open("post","${pageContext.request.contextPath}/AjaxValidateUsernameServlet",true);
					//设置请求头(post请求要设置请求头)
				xmlHttpRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
				//3.发送请求
					/*
					这一步要注意:
						1.post方式和get方法携带参数的方式不同的,就像表单中post方式和get方法携带参数的方式不同的,post携带参数参考下面的代码:
						2.下面的参数是username,这个username和表单中的name值并无关系
					*/
				xmlHttpRequest.send("username="+$("username").value);
				//4.编写回调函数
				xmlHttpRequest.onreadystatechange = function(){
					if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
						var flag = xmlHttpRequest.responseText;
						if(flag==0){//如果后台的返回值为flag=true,!flag就是flase
							$("username_msg").innerHTML = "<font color='green'>用户名可以使用</font>";
							//禁用表单的提交按钮:$("subBtn").disabled = true/false;
							$("subBtn").disabled = false;
						}else{
							$("username_msg").innerHTML = "<font color='red'>用户名已被注册</font>";
							//禁用表单的提交按钮:$("subBtn").disabled = true/false;
							$("subBtn").disabled = true;
						}
					}
				}
			}
			$("username").onfocus = function(){
				$("username_msg").innerHTML = "";
			}
		}
	</script>
</head>
<body>
	<h1>使用原生AJAX在注册验证用户名是否存在</h1>
	<h3>提示:已存在的用户有aaa,bbb,ccc</h3>
	<form action="#">
		<table>
			<tr>
				<td>账户:</td>
				<td><input type="text" name="username" id="username" /></td>
				<td><span id="username_msg"></span></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colSpan="2" align="center"><input type="submit" value="注册" id="subBtn"/></td>
			</tr>
		</table>
	</form>
</body>
</html>