<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="../resources/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#btn1").click(function(){
			var url = $("#path").val()+"/JqueryAjax_get_Servlet";
			/*
			不管参数为何种形式,请求方式都是get,也就是说:通过$.get()方式发送的ajax请求的请求方式不会因为参数形式不同而发生改变
			*/
			//var params = {"username":"王五--get"};
			var params = "username=张三--get";
			$.get(url,params,function(responeText){
				alert("响应内容:"+responeText);
			});
		});
	});
	</script>
</head>
<body>
	<!-- 存放项目路径的隐藏域 -->
	<input type="hidden" value="${pageContext.request.contextPath}" id="path"/>
	<input type="button" value="get方式 发送ajax请求" id="btn1"/>
</body>
</html>