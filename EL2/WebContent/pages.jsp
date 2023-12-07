<%@ page language="java" import="javax.naming.*,javax.sql.*,java.sql.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int pageSize = 10;//每页行数
		int allRecords = 0;//总行数 
		int totalPages = 0;//总页数
		int pageIndex = 1;//当前页
		try {
			//javax.naming.Context提供了查找JNDI的接口
			Context ctx = new InitialContext();
			//java:comp/env/为前缀，通过lookup查找
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/emp");
					
			conn = ds.getConnection();
			stmt = conn.createStatement();
			//获取总行数
			rs = stmt.executeQuery("SELECT count(*) FROM emp");
			if (rs.next()) {
				allRecords = rs.getInt(1);
			}
			//计算总页数
			totalPages = (allRecords % pageSize == 0) ? (allRecords / pageSize)
					: (allRecords / pageSize + 1);
			//获得当前页
			String pageIndexStr = request.getParameter("pageIndex");
			if (pageIndexStr == null) {
				pageIndexStr = "1";
			}
			pageIndex = Integer.parseInt(pageIndexStr);
			//执行分页查询SQL语句，获取结果集 
			String sql = "SELECT employee_id, last_name, hire_date FROM (SELECT ROWNUM AS rn, t.* FROM (SELECT * FROM employees ORDER BY hire_date desc) t WHERE ROWNUM <= "
					+ pageSize
					* pageIndex
					+ ")WHERE rn >"
					+ pageSize
					* (pageIndex - 1);
			rs = stmt.executeQuery(sql);
	%>
	<table border="1">
		<caption>人力资源系统员工信息</caption>
		<tr>
			<th>员工ID</th>
			<th>员工姓氏</th>
			<th>雇佣日期</th>
		</tr>
		<%
			//5、操作结果集
				while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("employee_id")%></td>
			<td><%=rs.getString("last_name")%></td>
			<td><%=rs.getString("hire_date")%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		if (pageIndex > 1) {
	%>
	<a href="pages.jsp?pageIndex=1">首页</a>&nbsp;
	<a href="pages.jsp?pageIndex=<%=pageIndex - 1%>">上一页</a>
	<%
		}
			if (pageIndex < totalPages) {
	%>
	<a href="pages.jsp?pageIndex=<%=pageIndex + 1%>">下一页</a>
	<a href="pages.jsp?pageIndex=<%=totalPages%>">末页</a>
	<%
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6、关闭连接
			try {
				if (null != stmt) {
					stmt.close();
				}
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	%>
</body>
</html>