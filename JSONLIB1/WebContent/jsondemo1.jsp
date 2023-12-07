<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		window.onload = function(){
			var person1 = {"name":"张三","age":18,"sex":"male"};
			//alert(person1.name+person1.age+person1.sex);
			//注意：当值为数字时，键可以不使用双引号括起来
			var person2 = {"name":"张三",age:88,"sex":"male"};
			//alert(person2.name+person2.age+person2.sex);
			//演示解析json字符串
			var str1 = "{\"name\":\"张三\",\"age\":18,\"sex\":\"male\"}";
			var p3 = eval("("+str1+")");
			//alert(p3.name+p3.age+p3.sex);
			var str3 = "1 + 2" ;
			//alert(eval("("+str3+")"));
		}
	</script>
</head>
<body>
	<h1>演示解析JSON对象和JSON字符串</h1>
</body>
</html>