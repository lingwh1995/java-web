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
			$("td").height("30px");
		})
	</script>
<style>
	#div {
		margin: 100px auto;
		width: 40%;
		text-align: center;
	}
	table {
		 border-collapse:collapse;
		 width: 100%;
	}
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
	<div id="div">
		<form action="<c:url value="/QueryBooksByNameServlet"/>">
			根据名称查询:<input type="text" name="bookName"/>
			<input type="submit" value="查询">
		</form>
		<form action="<c:url value="/QueryBookByIdServlet"/>">
			<input type="hidden" name="flag" value="1">
			根据id查询:<input type="text" name="bookId"/>
			<input type="submit" value="查询">
		</form>
		<table border="1px solid black">
			<tr>
				<th>图书名称</th>
				<th>图书价格</th>
				<th>图书库存</th>
				<th>图书操作</th>
			</tr>
			<c:forEach items="${bookList }" var="book">
				<tr>
					<td><a href="<c:url value="/QueryBookByIdServlet?flag=2&bookId=${book.bookId}"/>">
							${book.bookName}
						</a>
					</td>
					<td>${book.bookPrice }</td>
					<td>${book.bookCount }</td>
					<td>
						<a href="<c:url value="/DeleteBookByIdServlet?bookId=${book.bookId}"/>">
							删除图书
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="<c:url value='/QueryBooksServlet?currentPage=1'/>">首页</a>
		<c:if test="${mypage.currentPage >1}">
			<a href="<c:url value='/QueryBooksServlet?currentPage=${mypage.currentPage-1 }'/>">上一页</a>
		</c:if>
		<a href="<c:url value='/QueryBooksServlet?currentPage=${mypage.currentPage }'/>">第${mypage.currentPage }页</a>
		<c:if test="${mypage.currentPage< mypage.totalPage}">
			<a href="<c:url value='/QueryBooksServlet?currentPage=${mypage.currentPage+1 }'/>">下一页</a>
		</c:if>
		<a href="<c:url value='/QueryBooksServlet?currentPage=${mypage.totalPage }'/>">尾页</a>
	</div>
</body>
</html>