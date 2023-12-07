<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	//演示JS完成页面刷新
		window.onload = function(){
			var btn = document.getElementById("btn");
			var h1 = document.getElementById("h1");
			btn.onclick = function(){
				h1.innerHTML = "Hello World";
			}
		}
	</script>
</head>
<body>
	<%--
		AJAX: asynchronous JavaScript and xml，异步交互的js和xml，即使用JS向服务器发送的接受服务器回传的数据
		注意：服务器给客户端的响应一般是整个页面，一个html完整页面，但是AJAX中是局部刷新，服务器不用在响应真个页面，而只是数据
		响应数据的格式(必须是java和js都识别的数据，如下面的)：
					txt：纯文本
					xml：
					json：是js提供的数据交互格式，在ajax中最受欢迎
		同步交互：1.发一个请求，就要等待服务器的响应结束，然后才能发第二个请求，中间有一个等待的时间
			    2.刷新的是整个页面
	          异步交互：1.发一个请求后，无需等待服务器的影响，然后就可以发第二个请求
	          	2.可以使用js接受服务器的响应，然后可以使用js完后局部刷新
	          	
	    AJAX的优缺点：
	    		优点：1.异步交互，增强了用户的体验
	    			 2.性能：因为服务器无需响应整个页面，只需要响应整个页面，只需要响应部分内容，所以服务器的压力减轻了
	    		缺点：1.ajax不能应用在所有场景
	    			 2.ajax不停的向服务器发送请求，访问服务器发送的次数增多了，无端的增加了服务器压力
	 --%>	
	 <h1>演示js局部刷新</h1>
	 <button id="btn">点击这里</button>
	 <h1 id="h1"></h1>
	 <a href="${pageContext.request.contextPath }/ajax_get.jsp">get请求方式的原生ajax请求</a><br />
	 <a href="${pageContext.request.contextPath }/ajax_post.jsp">post请求方式的原生ajax请求</a><br />
	 <a href="${pageContext.request.contextPath }/ajax_validateUsername.jsp">post请求方式的原生ajax验证用户名是否存在</a>
</body>
</html>