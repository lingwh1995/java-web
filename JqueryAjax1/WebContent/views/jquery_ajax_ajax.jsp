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
			var url = $("#path").val()+"/JqueryAjax_ajax_Servlet";
			//var params = {"username":"赵六--post"};
			var params = "username=张三--post";
			/*
				$.ajax()方式发送ajax请求
				$.ajax({
					url,
					type,
					data,
					success,
					error,
					dataType:"json",
					async
				});
			*/
			$.ajax({
				url:url,
				type:"post",
				data:params,
				success:function(jsonObj){
					//alert(jsonObj);
					alert(jsonObj.a);
				},
				error:function(){
					alert("失败...");
				},
				dataType:"json",
				async:"true"
			});
		});
	});
	</script>
</head>
<body>
	<!-- 存放项目路径的隐藏域 -->
	<input type="hidden" value="${pageContext.request.contextPath}" id="path"/>
	<input type="button" value="$.ajax()式 发送ajax请求" id="btn1"/>
</body>
</html>