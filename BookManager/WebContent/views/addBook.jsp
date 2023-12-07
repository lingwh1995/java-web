<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#add").click(function(){
				$("#add").val("保存");
				$("td").each(function(index,element){
					//注意：这里取值是text不是val
					//$(this).html("<input value='"+$(this).val+"'/>");
					$(this).html("<input type='text' value='"+$(this).text()+"'/>");
				})
				$($("td input")[0]).attr("name","bookName");
				$($("td input")[1]).attr("name","bookPrice");
				$($("td input")[2]).attr("name","bookCount");
				$(this).parent().html("<input type='submit' value='保存'/>");
				//$("#add").parent().html("<input type='submit' value='保1存' id='sav'/>");
			})
		})
	</script>
</head>
<body>
	<form action="<c:url value='/UpdateBoookServlet'/>">
		<table border="1px solid black" cellSpacing="0">
			<tr>
				<th>图书名称</th>
				<td>${bookList[0].bookName}</td>
			</tr>
			<tr>
				<th>图书价格</th>
				<td>${bookList[0].bookPrice }</td>
			</tr>
			<tr>
				<th>图书库存</th>
				<td>${bookList[0].bookCount }</td>
			</tr>	
		</table>
		<input type="hidden" name="bookId" value="${bookList[0].bookId}"/>
		<p><input type="button" value="修改" id="add"/></p>
	</form>
</body>
</html>