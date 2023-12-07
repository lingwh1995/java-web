<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function createxmlHttpRequest(){
			try {
				return new XMLHttpRequest();
			} catch (e) {
				try {
					return new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						return new ActiveXObject("Miscroft.XMLHTTP");
					} catch (e) {
						throw e;
					}
				}
			}
		}
		window.onload = function(){
			function $(id){return document.getElementById(id);}
			$("btn").onclick = function(){
				//1.得到异步对象
				var xmlHttp = createxmlHttpRequest();
				//2.打开连接
				xmlHttp.open("get","/CZ_JSONDemo1/JsonServlet",true);
				//3.发送请求
				xmlHttp.send(null);
				//4.获得回传数据
				xmlHttp.onreadystatechange = function(){
					if(xmlHttp.readyState ==4 && xmlHttp.status==200){
						var text = xmlHttp.responseText;
						var pserson = eval("("+text+")");
						//alert(pserson.name+pserson.age+pserson.sex);
					    $("h1").innerHTML = pserson.name+pserson.age+pserson.sex;
					}
				}
			}
		}
	</script>
</body>
	<button id="btn">点击测试ajax传输json格式数据</button>
	<h1 id="h1"></h1>
</html>