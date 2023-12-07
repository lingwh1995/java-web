<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellSpacing="0" align="center" width="80%">
		<tr> 
			<th>商品编号</th>
			<th>商品图片</th>
			<th>商品名称</th>
			<th>市场价</th>
			<th>商城价</th>
			<th>商品描述</th>
			<th>操作</th>
		</tr> 
		<c:forEach items="${pageBean.list }" var="p">
			<tr>
				<td width="6%">${p.pid }</td>
				<td width="6%"><img src="${pageContext.request.contextPath }/${p.pimage }" width="80px"/></td>
				<td width="6%">${p.pname }</td>
				<td width="6%">${p.market_price }</td>
				<td width="6%">${p.shop_price }</td>
				<td >${p.pdesc }</td>
				<td width="6%">
					修改|删除
				</td>
			</tr>
		</c:forEach>
	</table>
	<center>
			<!-- 如果是第一页,首页和上一页不展示 -->
			<%-- <c:if test="${pageBean.currentPage >1 }"> --%>
			<c:if test="${pageBean.currentPage !=1 }">
				<a href="${pageContext.request.contextPath }/showProductByPageServlet?currentPage=1">[首页]</a>
				<a href="${pageContext.request.contextPath }/showProductByPageServlet?currentPage=${pageBean.currentPage-1 }">[上一页]</a>
			</c:if>
			
			<!-- 展示所有的页面 -->
			<c:forEach begin="1" end="${pageBean.totalPage }" var="n">
				<c:if test="${pageBean.currentPage<n && n<pageBean.currentPage+5}">
					<a href="${pageContext.request.contextPath }/showProductByPageServlet?currentPage=${n}">[第${n}页]</a>
				</c:if>
			</c:forEach> 
			
			<!-- 如果是最后一页,尾页和下一页不展示 -->
			<c:if test="${pageBean.currentPage != pageBean.totalPage}">
				<a href="${pageContext.request.contextPath }/showProductByPageServlet?currentPage=${pageBean.currentPage+1 }">[下一页]</a>
				<a href="${pageContext.request.contextPath }/showProductByPageServlet?currentPage=${pageBean.totalPage }">[尾页]</a>
			</c:if>
			第${pageBean.currentPage }页/共${pageBean.totalPage }页
	</center>
</body>
</html>