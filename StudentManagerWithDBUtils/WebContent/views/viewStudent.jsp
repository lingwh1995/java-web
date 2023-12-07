<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				$("#btn").val("保存");
				/*
				//方式一:使用for循环遍历
				for(var i=0;i<$("tr td:odd").size();i++){
					//alert($("tr td:odd").get(i).innerText);
					$($("tr td:odd").get(i)).html("<input value='"+$($("tr td:odd").get(i)).text()+"'/>")
				}
				*/
				//方式二:使用each遍历
				$("tr td:odd").each(function(index,element){//可以是element或者ele或者其他任何字符
					$(this).html("<input value='"+$(this).text()+"'/>");
				});
				//注意:$("tr td:eq(1)")值选中了td,没有选中input框，要选中input输入框，要这样：$("tr td:eq(1) input")
				$("tr td:eq(1) input").attr("readonly","readonly").attr("name","stuNo");
				$("tr td:eq(3) input").attr("name","stuName");
				$("tr td:eq(5) input").attr("name","stuAge");
				
				//把<input type="button" value="修改" id="btn"/>改为
				//<input type="submit" value="保存"/>
				//注意：1.this在这里代表button   2.把DOM的this转换为jQuery，this不要用双引号括起来 3.要改变this的html值，必须通过其父类来改变
				$(this).parent().html("<input type='submit' value='保存'/>");
				//$(this).parent().html("<input id='saveId' type='submit' value='保存'  /> ") ;
			});
		});
	</script>
</head>
<body>
	<form action="UpdateStudentByStuNoServlet">
		<table border="1px solid black" cellSpacing="0">
			
			<tr>
				<td>学号</td>
				<td>${students[0].stuNo }</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>${students[0].stuName }</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td>${students[0].stuAge }</td>
			</tr>
		</table>
		<p><input type="button" value="修改" id="btn"/></p>
	</form>
</body>
</html>