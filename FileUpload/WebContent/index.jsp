<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>文件上传(未处理细节问题)</h1>
	<form action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data">
		用户名:<input type="text" name="username"/><br />
		照   片:<input type="file" name="pic"/><br />
		<input type="submit" vale="提交"/>
	</form>
	<h1>文件上传(处理了细节问题)</h1>
	<form action="${pageContext.request.contextPath }/UploadServlet1" method="post" enctype="multipart/form-data">
		用户名:<input type="text" name="username"/><br />
		照   片:<input type="file" name="pic"/><br />
		<input type="submit" vale="上传"/>
	</form>
</body>
</html>