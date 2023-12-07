package com.ronin.test;


import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.ronin.jdbc.JdbcUtils;


public class JdbcUtilsTest {
	
	/**
	 * 测试jdbcUtils获取连接功能+测试jdbcUtils关闭连接功能
	 * 
	 */
	@Test
	public void testJdbcUtils() throws SQLException{
		//获取连接
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
		//关闭连接
		JdbcUtils.releaseConnection(conn);
			//测试是否关闭了连接
		System.out.println(conn.isClosed());
	}
	
	/**
	 * 测试jdbcUtils中与事务相关的功能
	 * 
	 */
	public void testTransaction() throws SQLException{
		//开启事务
		JdbcUtils.beginTransaction();
		//获取链接，对多个事务进行多次操作,错误就执行回滚操作
		try{
			JdbcUtils.commitTransaction();
		}catch (Exception e) {
			try {
				//回滚事务
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO: handle exception
			}
		}
	}
}
