package org.lanqiao.customerdatasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtils {
	//使用静态代码块优化后，这个代码只会执行一次加载到内存中，而不是多次
	static final String DRIVERCLASS;
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	
	static {
		//通过ResuorceBundle对象获取连接参数
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");//只写文件名，不写后缀
		//多行编辑(块编辑)快捷键：Alt+Shit+A
		DRIVERCLASS = bundle.getString("driverClassName");
		URL = bundle.getString("url");
		USER = bundle.getString("user");
		PASSWORD = bundle.getString("password");
	}
	
	static {
		//注册驱动
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException  {
		Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
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
