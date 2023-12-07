package org.lanqiao.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class DBPoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 数据库连接池的使用：
		 * 1.创建配置文件，context.xml
		 * 2.放到WEB-INF文件夹下
		 * 3.创建命名对象
		 * 4.对资源进行查询
		 * 5.通过获取到的资源创建连接
		 * 6.完成数据库的操作
		 */
		Connection conn = null;
		try {
			//创建命名对象
			InitialContext ctx = new InitialContext();
			//对资源进行查询
				//在context.xml中找到jdbc/emp这个资源
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/emp");
			//通过获取到的资源创建连接
			conn = ds.getConnection();
			//完成对数据库的操作
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMP WHERE EMPNO = ?");
			ps.setInt(1, 7369);
			ResultSet rs = ps.executeQuery();
			//获取数据
			while(rs.next()) {
				String eName = rs.getString("ENAME");
				int empNo = rs.getInt("EMPNO");
				System.out.println(eName+"------"+empNo);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
