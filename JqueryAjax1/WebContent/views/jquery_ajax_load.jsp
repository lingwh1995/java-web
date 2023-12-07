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
			var url = $("#path").val()+"/JqueryAjax_load_Servlet";
			/*
			注意:
				1.参数的两种形式:普通形式和json形式
				2.若参数为形式1,则load()方法的请求方式为get方法,若参数为json形式,则load()方法的
				    请求方式为post，也就是说,load()方法的请求方式是随着参数形式的不同而改变的
			*/
				//形式1:
			//var params = "username=张三--load";
				//形式2:
			var params = {"username":"李四--load"};
			$(this).load(url,params,function(responeText){
				alert("响应内容:"+responeText);
			});
		});
	});
	</script>
</head>
<body>
	<!-- 存放项目路径的隐藏域 -->
	<input type="hidden" value="${pageContext.request.contextPath}" id="path"/>
	
	<input type="button" value="load方式 发送ajax请求" id="btn1"/>
	
</body>
</html>