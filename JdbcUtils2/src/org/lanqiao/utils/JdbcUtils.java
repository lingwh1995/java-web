package org.lanqiao.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 演示JDBC使用C3P0连接池来获取连接
 * @author ronin
 *
 */
public class JdbcUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	private static Properties props = null;
	
	/**
	 * 获取连接池
	 * @return
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	/**
	 *  获取连接!
	 */
	public static Connection getConnection() throws SQLException {
		// 得到Connection
		return dataSource.getConnection();
	}
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
