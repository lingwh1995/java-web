<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = "";
		String uname = (String)session.getAttribute("uname");
		if(uname != null){
			username = uname;
		}else {
			request.setAttribute("msg", "请先进行登录再来这个页面");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	%>
	<h3>欢迎<%=username %>光临本网站</h3>
</body>
</html>