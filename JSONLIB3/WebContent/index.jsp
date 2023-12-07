<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function createJSON(){
		// 声明JSON对象
		var json = {
					"username":"zhangsan", 
					"age":20, 
					"education":[
					             {
					            	 "primaryschool":"xiwang", 
					            	 "total":40
					             },
		             			 {
					            	 "middleschool":"shiyan",
					            	 "total":41
					             }
					            ],
					  "show": function(){
						  alert(this.education[1].middleschool);
					  }
					};
		json.show();
	}
</script>
</head>
<body>
	<input type="button" value="show" onclick="createJSON();" />
</body>
</html>