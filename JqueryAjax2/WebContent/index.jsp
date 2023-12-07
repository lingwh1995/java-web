<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="resources/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			//给username表单输入框添加一个失去焦点事件并发送ajax请求
			$("input[name='username']").blur(function(){
				//1.获取用户输入的值
				var $username = $(this).val();
				//2.发送ajax请求
					//2.1设置请求的url
				var url = $("#path").val()+"/ValidateUserNameIsExistServlet";
					//2.2设置请求的参数
				var params = {"username":$username};
					//2.3.发送请求并设置回调函数
				$.post(url,params,function(response){
					if(response==1){
						//写入信息并禁用提交按钮
						$("#username_msg").html("<font color='red'>用户名已经存在</font>");
						$("input[type='submit']").attr("disabled","disabled");
					}else{
						//写入信息并启用提交按钮
						$("#username_msg").html("<font color='green'>用户名可以使用</font>");
						$("input[type='submit']").attr("disabled","enabled");
					}
				});
			}).focus(function(){
				$("#username_msg").html("");
			});
		});
	</script>
</head>
<body>
	<input type="hidden" value="${pageContext.request.contextPath }" id="path"/>
	<h1>使用jquery的AJAX在注册验证用户名是否存在</h1>
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