package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * 
 * 演示PrepareStatement的用法
 *
 */
public class JDBCDemo6 {
	/*
	 * PrepareStatement是一个接口，是Statement接口的子接口，功能更为强大
	 * 优点： ①可以防止SQL攻击
	 * 	    ②可以提高代码的可读性，可维护性
	 * 		③提高效率
	 * SQL攻击：在需要用户输入的地方，用户输入的是SQL语句的片段，最终用户输入的SQL片段与我们DAO中写的SQL语句合成一个完整
	 * 		      的SQL语句！例如用户在登录时输入的用户名和密码都是为SQL语句的片段！
	 */
	public static boolean login(String username,String password) throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String classDriverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb1";
		String uname = "root";
		String pwd = "123";
		
		try {
			Driver driver = new Driver();//导入JDBC的包
			DriverManager.registerDriver(driver);
			conn =  DriverManager.getConnection(url,uname,pwd);
			st = conn.createStatement();
			String sql = "SELECT * FROM USER WHERE USERNAME = '"+username+"'AND PASSWORD = '"+password+"'";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			return rs.next();
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			if(rs!=null) { rs.close();}
			if(st!=null) {st.close();}
			if(conn!=null) {conn.close();}
		}
	}
	public static void main(String[] args) throws SQLException {
		String username = "a' or 'a'= 'a";
		String password = "b' or 'b'= 'b";
		System.out.println(login(username,password));
	}
}
