<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
	<script type="text/javascript">
		function queryPage(cPage){
			window.location = "QueryStudentsByPage?cPage="+cPage.value ;
		}
		$(function(){
			var cPageValue = $("#cPageValueId").val()-1;
			$("option:eq("+cPageValue+")").attr("selected","selected")
		})
	</script>
</head>
<body>
	<form action="<c:url value="/QueryStudentByStuNameServlet"/>">
		按姓名查询(模糊查询)：<input name="stuName">	
		<input type="submit" value="查询"/>
	</form>
	<form action="<c:url value="/QueryStudentByStuNoServlet"/>">
		按学号查询(精确查询)：<input name="stuNo">	
		<input name="flag" type="hidden" value="1"/>
		<input type="submit" value="查询"/>
	</form>
	<table border="1px solid black" cellSpacing=0>
		
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>操作</td>
			</tr>
		<c:if test="${students !=null}"><!--el表达式可以判断是否为null-->
			</tr>
				<c:forEach items="${students}" var="stu">
					<tr>
						<td><a href="<c:url value='/QueryStudentByStuNoServlet'/>?stuNo=${stu.stuNo }&flag=2"><c:out value="${stu.stuNo }"/></a></td>
						<td><c:out value="${stu.stuName }"/></td>
						<td><c:out value="${stu.stuAge }"/></td>
						<td><a href="<c:url value='/DeleteStudentByStuNoServlet'/>?stuNo=${stu.stuNo }">删除</a></td>
					</tr>
				</c:forEach>	
		</c:if>
	</table>
	<a href="<c:url value="/views/add.jsp"/>"><button>增加</button></a><br>
	<a href="QueryStudentsByPage?cPage=1">首页</a>
	<c:if test="${studentPage.currentPage>1 }">
		<a href="QueryStudentsByPage?cPage=${studentPage.currentPage -1}">上一页</a>
	</c:if>
	<a href="QueryStudentsByPage?cPage=${studentPage.currentPage }">${studentPage.currentPage }</a>
	<c:if test="${studentPage.currentPage <studentPage.totalPage}">
		<a href="QueryStudentsByPage?cPage=${studentPage.currentPage +1}">下一页</a>
	</c:if>
	<a href="QueryStudentsByPage?cPage=${studentPage.totalPage}">尾页</a>
	<hr />
	<select style="width:20%;">
		<c:forEach var="i" begin="1" end="${studentPage.totalPage}" step="1">
			<option value="${i}" onclick="queryPage(this);">${i}</option>
		</c:forEach>
	</select>
	<input id="cPageValueId" type="hidden"  value="${studentPage.currentPage }" />
</body>
</html>