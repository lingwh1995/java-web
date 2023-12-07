<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>演示直接使用超链接进行下载</h1>
		<a href="<c:url value='/resource/bird.jpg' />" >下载resource下的bird.jpg</a><br />
		<a href="<c:url value='/resource/鸟.jpg' />" >下载resource下的鸟.jpg</a><br />
		<a href="<c:url value='/resource/day10.txt' />" >下载resource下的day10.txt</a><br />
		<a href="<c:url value='/resource/day10.xls' />" >下载resource下的day10.xls</a><br />
		<!-- 注意 :这种下载方式只能下载浏览器不能识别的文件类型，但是像图片这种浏览器可以直接读懂的文件，使用
			     这种方式下载的结果是在一个页面打开这些文件，而不是出现下载的效果
		-->
		<h1>演示使用servlet进行下载</h1>
		<a href="<c:url value='/Downloadservlet?name=bird.jpg' />" >下载resource下的bird.jpg</a><br />
		<a href="<c:url value='/Downloadservlet?name=鸟.jpg' />" >下载resource下的鸟.jpg(编码文件名下载)</a><br />
		<a href="<c:url value='/Downloadservlet?name=day10.txt' />" >下载resource下的day10.txt</a><br />
		<a href="<c:url value='/Downloadservlet?name=day10.xls' />" >下载resource下的day10.xls</a><br />
		<c:url value='/resource/Downloadservlet' />
</body>
</html>