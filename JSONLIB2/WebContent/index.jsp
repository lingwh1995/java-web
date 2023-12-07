<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		// JSON格式字符串
		var jsonStr = "{\"username\":\"zhangsan\", age:20}";
		var jsonArrayStr = "{param:[{username:\"zhangsan\", age:20},{clazzname:\"clazzone\", level:2}]}";
		var jsonAllStr = "{param:[{username:\"zhangsan\", age:20},{clazzname:\"clazzone\", level:2}], total:20}";
		// 转换JSON格式字符串为JSON对象
		var json = eval("(" + jsonStr + ")");
		var jsonArray = eval("(" + jsonArrayStr +")");
		var jsonAll = eval("("+ jsonAllStr + ")");
		// alert(json.username);
		// alert(jsonArray.param[1].clazzname);
		// alert(jsonAll.param[1].level);
		alert(jsonAll.total);
	})
</script>
</head>
<body>

</body>
</html>