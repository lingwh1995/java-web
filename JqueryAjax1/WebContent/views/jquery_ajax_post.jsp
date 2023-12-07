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
			var url = $("#path").val()+"/JqueryAjax_post_Servlet";
			//var params = {"username":"赵六--post"};
			var params = "username=张三--post";
			//不设置回传数据的格式
			/*
			$.post(url,params,function(responeText){
				alert("响应内容:"+responeText);
			});
			*/
			//将回传数据的格式设置为json格式,要求后台的数据必须是json格式,jquery会自动把json字符串封装成json对象
			$.post(url,params,function(jsonObject){
				alert("响应内容:"+jsonObject);
				alert(jsonObject.a);
			},"json");
		});
	});
	</script>
</head>
<body>
	<!-- 存放项目路径的隐藏域 -->
	<input type="hidden" value="${pageContext.request.contextPath}" id="path"/>
	<input type="button" value="post方式 发送ajax请求" id="btn1"/>
</body>
</html>