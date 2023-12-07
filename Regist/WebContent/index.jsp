<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="css/bootstrap.css" rel="stylesheet"/>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
</head>
<body>
	<div style="border:1px solid red" class="container">
		<form action="<c:url value="/RequestServlet" />">
		    <div class="form-group">
			    <label for="username">用户名</label>
			    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
		    </div>
		    <div class="form-group">
			    <label for="password">密码</span></label>
			    <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
		    </div>
		   	<!-- 后台获取通过checkbox传递的值 -->
		    <div class="checkbox">
			    <label>
			      <input type="checkbox" name="gender" value="man"> 男
			    </label>
			    <label>
			      <input type="checkbox" name="gender" value="womean"> 女
			    </label>
		    </div>
	  		<button type="submit" class="btn btn-default">Submit</button>
		</form>
		<!-- 携带多个请求参数的超链接 	<a href="项目名/RequestServlet?parmas=zs&parmas=ls&parmas=eat">携带多个请求参数的超链接</a>-->
		<a href="<c:url value="/RequestServlet"/>?parmas=zs&parmas=ls&parmas=eat">携带多个请求参数的超链接</a>
	</div>
	
	
	<hr >
	
	
	
	<div style="border:1px solid red" class="container">
			<h1>用来测试样式表单,没有设置与后台发生交互的功能</h1>
			<form action="#" class="form-horizontal">
			<label for="username" class="col-sm-2 control-label">账户</label>
		    <div class="form-group col-sm-10">
			    <input type="text" class="form-control" id="username" name="username" placeholder="请输入账户">
		    </div>
		    
			<label for="password" class="col-sm-2 control-label">密码</label>
		    <div class="form-group col-sm-10">
			    <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
		    </div>
		    
			<label for="email" class="col-sm-2 control-label">邮件</label>
		    <div class="form-group col-sm-10">
			    <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮件">
		    </div>
		    
		    <div class="form-group">
		    	<div class="col-sm-offset-2 col-sm-10 checkbox">
					    <input type="radio" name="sex" value="man"> 男</label>
					    <label><input type="radio" name="sex" value="womean"> 女</label>
			    </div>
		    </div>
		    
		    <div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
	  				<button type="submit" class="btn btn-default">注册</button>
    	 		</div>
 		    </div>
 		    
		</form>
	</div>
</body>
</html>