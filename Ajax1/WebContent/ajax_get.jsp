<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function createHttpRequest(){
			try {
				return new XMLHttpRequest();
			} catch (e) {
				try {
					return new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						return new ActiveXObject("Miscrosoft.XMLHTTP");
					} catch (e) {
						throw e;
					}
				}
			}
		}
		window.onload = function(){
			function $(id){return document.getElementById(id);}
			var btn = $("btn");	
			btn.onclick = function(){
				//第一步：得到异步对象
				var xmlHttpRequest = createHttpRequest();
				//第二步：打开连接
				//发送get请求
				xmlHttpRequest.open("get","${pageContext.request.contextPath}/AjaxServlet1",true);
				//第三步：发送请求
					//不传递任何参数
				//xmlHttpRequest.send(null);
					//传递参数
				xmlHttpRequest.send("username=zs&pwd=123");
				//第四步：给异步对象的onreadystatechange()事件注册监听事件
				xmlHttpRequest.onreadystatechange = function(){
					if(xmlHttpRequest.readyState==4 &&xmlHttpRequest.status==200){			
						//get
						var text = xmlHttpRequest.responseText;//后面没有括号
						$("h1").innerHTML = text;
					}
				}
			}
		}
	</script>
</head>
<body>
	<h1>ajax发送get请求</h1>
	<button id="btn">AJAX</button>
	<h1 id="h1"></h1>
</body>
</html>