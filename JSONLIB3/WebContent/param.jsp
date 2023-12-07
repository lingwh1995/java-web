<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		// 创建JSON对象
		var json = {
				"username":"lisi", 
				"history":[
				           		{
				           			"first":"guangrongbang",
				           			"second": "huojiang"
				           		},
				           		{
				           			"work":"feisibuke",
				           			"sal":1
				           		}
				          ]
				};
		// 为方便传输，转换JSON对象为字符串
		var param = JSON.stringify(json);
		// 传输JSON格式数据
		$.post("ShowServlet", {"param": param},
				function(x){
					alert(x);				
				}, "html");
	})
</script>
<title>Insert title here</title>
</head>
<body>

</body>
</html>