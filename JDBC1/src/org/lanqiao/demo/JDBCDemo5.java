package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

/**
 * 
 * JDBC结果集(ResultSet)详解
 *
 */
public class JDBCDemo5 {
	@Test
	public void function() throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String classDriverName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mydb1";
			String username = "root";
			String password = "123";
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url,username,password);
			st = conn.createStatement();
			/*
			 * 结果集特性：当使用Connection的createStatement时，已经确认了Statement生成的结果集是什么特性
			 * 结果集有一下特性：
			 * 是否可滚动
			 * 是否敏感
			 * 是否可更新
			 * createStatement(int resultSetType, int resultSetConcurrency) 
			 * 第一个参数：
			 * 而mysql数据可使用createStatement生成的结果集的特性是：可滚动、不敏感、不可更新
			 * ResultSet.TYPE_FORWARD_ONLY:不滚动结果集(mysql默认可滚动)
			 * ResultSet.TYPE_SCROLL_INSENSITIVE:滚动结果集，但是结果集不会跟随着数据不会再随着数据库而变化(不敏感)
			 * ResultSet.TYPE_SCROLL_SENSITIVE :滚动结果集，但是结果集会跟随着数据不会再随着数据库而变化(敏感：很耗费资源)
			 * 第二个参数：
			 * ResultSet.CONCUR_READ_ONLY:查询到的结果集是只读的
			 * ResultSet.CONCUR_UPDATABLE :更新结果集会导致数据库内容更新(通过结果集更改数据库)
			 */
			System.out.println(conn);
		} catch (Exception e) {
			throw new RuntimeException();
		}finally{
			if(rs!=null) {rs.close();}
			if(st!=null) {st.close();}
			if(conn!=null) {conn.close();}
		}
	}
}
