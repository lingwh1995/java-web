<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		//window是小写不是大写的
		window.onload = function(){
			//alert("a");
		}
		
		
		//带提示框的删除单个商品
		function deleteProduct(id){
			if(confirm("确定删除选中的商品？")){
				//正确写法
				//window.location.href = "${pageContext.request.contextPath }/deleteProdutByIdServlet?pid="+id;
				//正确写法
				window.location = "${pageContext.request.contextPath }/deleteProdutByIdServlet?pid="+id;
				
				//错误写法
				//window.location.href = ${pageContext.request.contextPath }+"/deleteProdutByIdServlet?pid="+id;
			}
		}
		
		//全选或者全不选
		function checkAll(obj){
			//获取选中转态
			//alert(obj.checked);
			var pids = document.getElementsByName("pid");
			//使用js独有的循环方式来遍历数组,注意:java中数组的长度是不可变的,js中数组的长度是可变的
			pids.forEach(function(ele,index){
				ele.checked = obj.checked;
			});
		}
		
		//提交表单并将需要删除选中的商品的id传到后台
		function delCheck(){
			//1.获取表单
			var form = document.getElementById("formId");
			//2.通过js提交表单
			form.submit();
		}
	</script>
</head>
<body>
	<table border="1" cellSpacing="0" align="center" width="80%">
	<!-- ---------------------------------------------------------------------------------------- -->
		<!-- 多条件组合查询 -->
		<form action="${pageContext.request.contextPath }/QueryProductByConditionServlet">
			<tr>
				<td colSpan="8">
					商品名称:<input type="text" name="pname"/>
					关键字:<input type="text" name="keyword"/>
					<input type="submit" value="查询"/>
				</td>
			</tr>
		</form>
	<!-- ---------------------------------------------------------------------------------------- -->
		<!-- 删除选中商品 -->
		<tr>
			<td colSpan="6"><input type="button" value="删除选中" onclick="delCheck();"></td>
			<td colSpan="2"></td>
		</tr>
	<!-- ---------------------------------------------------------------------------------------- -->
		<tr> 
			<th><input type="checkbox" onclick="checkAll(this)"></th>
			<th>商品编号</th>
			<th>商品图片</th>
			<th>商品名称</th>
			<th>市场价</th>
			<th>商城价</th>
			<th>商品描述</th>
			<th>操作</th>
		</tr> 
		<form id="formId" action="${pageContext.request.contextPath }/DeleteCheckServlet">
		<c:forEach items="${productList }" var="p">
			<tr>
				<td width="5%"><input type="checkbox" name="pid" value="${p.pid }"></td>
				<td width="5%">${p.pid }</td>
				<td width="5%"><img src="${pageContext.request.contextPath }/${p.pimage }" width="80px"/></td>
				<td width="5%">${p.pname }</td>
				<td width="5%">${p.market_price }</td>
				<td width="5%">${p.shop_price }</td>
				<td >${p.pdesc }</td>
				<td width="16%">
				<a href="${pageContext.request.contextPath }/QueryProdutByIdServlet?pid=${p.pid}">修改|</a>
				<a href="${pageContext.request.contextPath }/deleteProdutByIdServlet?pid=${p.pid}">普通的删除|</a>
				<a href="JavaScript:void(0)" onclick="deleteProduct('${p.pid}')">带提示的删除</a>
				</td>
			</tr>
		</c:forEach>
		</form>
	</table>
</body>
</html>