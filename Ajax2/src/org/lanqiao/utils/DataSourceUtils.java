package org.lanqiao.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	/**
	 * 创建一个连接
	 */
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	/**
	 * 设置ThreadLocal
	 */
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	
	/**
	 * 获取数据源
	 * @return
	 */
	public static DataSource getDataSource(){
		return ds;
	}
	
	/**
	 * 获取连接:
	 * 		注意:使用ThreadLocal后获取连接就要从当前线程获取,而不是连接池中获取
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		Connection conn = tl.get();
		if(conn==null){
			//第一次获取,需要创建一个连接盒当前的线程绑定
			conn = ds.getConnection();
			//绑定
			tl.set(conn);
		}
		return conn;
	}
	
	/**
	 * 释放三个资源资源
	 * @param conn 连接
	 * @param st 语句执行者
	 * @param rs 结果集
	 */
	public static void closeResource(Connection conn,Statement st,ResultSet rs)  {
		closeResource(st, rs);
		closeConn(conn);
	}
	
	/**
	 * 释放两个资源
	 * @param conn 连接
	 * @param st 语句执行者
	 * @param rs 结果集
	 */
	public static void closeResource(Statement st,ResultSet rs)  {
		closeResultSet(rs);
		closeStatement(st);
	}
	
	
	/**
	 * 释放连接
	 * 注意:释放的时候要和当前的线程解绑
	 * @param conn
	 */
	public static void closeConn(Connection conn) {
		if(conn!=null)
			try {
				conn.close();
				//和当前的线程解绑
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//当对象为空，GC就可以回收这个对象
				conn = null;
			}
	}
	/**
	 * 释放语句执行者
	 * 注意:释放的时候要和当前的线程解绑
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
	 * 注意:释放的时候要和当前的线程解绑
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
	
	
	/**
	 * 事务相关操作
	 * 		开启事务
	 * 		提交事务
	 * 		回滚事务
	 * @throws SQLException
	 */
	//开启事务
	public static void startTransaction() throws SQLException{
		//获取连接,开启事务
		getConnection().setAutoCommit(false);
	}
	
	//事务提交
	public static void commitAndCloseTransaction(){
		//获取连接
		try{
		Connection conn = getConnection();
		//提交事务
		conn.commit();
		//释放资源
		conn.close();
		//解除绑定
		tl.remove();
		}catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	//事务回滚
	public static void rollbacktAndCloseTransaction(){
		//获取连接
		try{
		Connection conn = getConnection();
		//回滚事务
		conn.rollback();
		//释放资源
		conn.close();
		//解除绑定
		tl.remove();
		}catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
}
