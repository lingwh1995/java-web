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
			//文本框keyup的时候发送ajax
			$("#tid").keyup(function(){
				//获取文本框的内容
				var $text = $(this).val();
				//当内容不为空时发送ajax请求,内容为空时不发送ajax请求
				if($text!=null && $text!=''){
					var param = {"keyword":$text};
					//清空上一次的查询结果
					$("#result").text("");
					$.post("/JqueryAjax3/SerarchByKeywordServlet",param,function(response){
						if(response!=null){
							var arr = response.split(",");
							$(arr).each(function(){
								//alert(this);
								//将每一个值放入id为result的div中,将其插入到id为result的div中
								$("#result").append("<div align='left'>"+this+"</div>");
								//注意:要清空每次查询后的结果
							});
						}
					});
				}
			});
		});
	</script>
</head>
<body>
	<center>
		<h1>点击搜索</h1>
		<div>
			<input type="text" name="kw" id="tid"/><input type="button" value="百度一下"/>
		</div>
		<div id="result" style=";width: 172px;position: relative;left: -33px;"></div>
	</center>
</body>
</html>