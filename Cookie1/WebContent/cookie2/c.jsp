<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>演示Cookie过期时间</h1>
	<hr />
	<%--
	     当服务器创建Cookie对象后，可以调用setMaxAge()方法设置Cookie的最大生命。
	  * maxAge > 0：表示Cookie在客户端硬盘上保存的最大时间，单位为秒；
	  * maxAge < 0：表示Cookie不会被浏览器保存到硬盘上，而只在浏览器内存中存活，一旦客户端关闭浏览器在，那么Cookie就消失；
	  * maxAge == 0：表示删除Cookie，例如客户端硬盘已经存在名为abc的Cookie，如果服务器再向客户端发送名为abc，并且maxAge为0的Cookie，那么表示删除客户端上的名为abc的Cookie。

	--%>
	<%
		Cookie cookie = new Cookie("ccc","CCC");
		//cookie.setMaxAge(60*60);//参数类型为int型数据，单位为秒
		//cookie.setMaxAge(0);//当设置过期时间为0时，cookie只存在于浏览器的内存中，也效果等同于删除cookie
		cookie.setMaxAge(-1);//过期时间， 浏览器会话结束时
		response.addCookie(cookie);
		//注意:如果不设置cookie过期时间，默认的过期时间是   	浏览会话结束时		
	%>
</body>
</html>