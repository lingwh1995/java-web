package org.lanqiao.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtilsDemo {
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		//1.加载配置文件
		InputStream in = JDBCUtilsDemo.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		Properties props = new Properties();
		props.load(in);
		System.out.println("已经获取配置文件中内容");
		//加载驱动
		String driverClassName = props.getProperty("driverClassName");
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		Class.forName(driverClassName);
		//得到Connection
		return DriverManager.getConnection(url,username,password);
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		System.out.println(conn);
	}
}
