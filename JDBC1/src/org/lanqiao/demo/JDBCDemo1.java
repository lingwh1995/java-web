package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * 
 * JDBC入门
 *
 */
public class JDBCDemo1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		 * JDBC四大参数
		 * driverClassName:com.mysql.jdbc.Driver
		 * url:jdbc:mysql://localhost:3306//数据库名称
		 * username:root
		 * password:123
		 */
		/**
		 * 补充：
		 * ClassNotFoundException出现原因：①没导入mysql驱动包②url地址输入错误
		 * SQLException：出现这个异常，必然是下面的语句导致的
		 * Connection conn = DriverManager.getConnection(url,username,password);
		 */
		//导入jar包
		//加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		/*
		 * 
		 */
//		注册驱动，下面两句和上面一句的作用相同
//		com.mysql.jdbc.Driver driver = new Driver();//本质是注册驱动
//		DriverManager.registerDriver(driver);
		String url = "jdbc:mysql://localhost:3306/mydb1";
		String username = "root";
		String password = "123";
		//创建数据库连接，得到连接对象
		Connection conn = DriverManager.getConnection(url,username,password);
		System.out.println(conn);
	}
}
