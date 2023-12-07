package org.lanqiao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 演示不使用配置文件的JdbcUtils工具类
 * @author ronin
 *
 */
public class JdbcUtils {
	
	//获取链接
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","123");
		return conn;								  
	}
	
	/**
	 * 释放资源
	 * @param conn 连接
	 * @param st 语句执行者
	 * @param rs 结果集
	 */
	public static void closeResource(Connection conn,Statement st,ResultSet rs)  {
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}
	/**
	 * 释放连接
	 * @param conn
	 */
	public static void closeConn(Connection conn) {
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//当对象为空，GC就可以回收这个对象
				conn = null;
			}
	}
	/**
	 * 释放语句执行者
	 * @param st
	 */
	public static void closeStatement(Statement st) {
		if(st!=null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//当对象为空，GC就可以回收这个对象
				st = null;
			}
	}
	/**
	 * 释放结果集
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//当对象为空，GC就可以回收这个对象
				rs = null;
			}
	}
}
