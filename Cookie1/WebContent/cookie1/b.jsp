<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cookie入门(利用Cookie完成会话跟踪技术)</h1>
	<hr />
	<h1>获取Cookie</h1>
	<%	
		//注意：Cookie是http协议的一部分，不属于java，所以php、.net等也有Cookie
		//获取服务器上次存储的Cookie,注意：获取到的Cookie是一个数组
		Cookie[] cookies = request.getCookies();
		//取出每一个Cookie
		if(cookies!=null){
			for(Cookie c:cookies){
				System.out.println("name:"+c.getName()+",value:"+c.getValue());
				out.print("name:"+c.getName()+",value:"+c.getValue()+"<br />");
			}
		}
	%>
</body>
</html>