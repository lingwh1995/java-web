<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	/*
		1.得到img元素
		2.修改
	*/
		function _change(){
			var imgEle = document.getElementById("img");			
			imgEle.src = "{pageContext.request.contextPath}/VerifyCodeServlet?a="+new Date().getTime();//点击没反应的原因是，图片被缓存了
	}
	</script>
</head>
<body>
	<h1>Login</h1>
	<%
		String message = "" ;
		String msg = (String)request.getAttribute("msg");
		if(msg != null){
			message = msg;
		}
		String uname = "" ;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){//注意:使用cookie之前要先判断cookie否为空
			for(Cookie c:cookies){
				if("uname".equals(c.getName())) {//查找名为uname的cookie
					uname = c.getValue();//获取这个cookie的值，给uname这个变量
				}
			}
		}
	%>
	<font color="red"><%=message %></font>
	<form action="{pageContext.request.contextPath}/LoginServlet" method="post">
		用户名:<input type="text" name="username" value="<%=uname %>"/><br />
		密    码:<input type="text" name="password"/><br />
		验证码：<input type="text" name="verifycode" size="3"/>
			  <img id="img" src="{pageContext.request.contextPath}/VerifyCodeServlet"/><a href="javascript:_change()">换一张</a>
			  <br />
		<input type="submit" value="登录">
	</form>
</body>
</html>