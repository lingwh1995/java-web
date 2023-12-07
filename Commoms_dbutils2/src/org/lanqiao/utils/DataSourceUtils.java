package org.lanqiao.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	/**
	 * 获取数据源(连接池)
	 * @return
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	/**
	 * 获取连接
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
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
