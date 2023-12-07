package org.lanqiao.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0硬编码
 * @author ronin
 *
 */
public class C3P0Demo1 {
	
	@Test
	public void fun1() throws PropertyVetoException, SQLException {
		//1.创建数据库连接池
		ComboPooledDataSource ds = new ComboPooledDataSource();
		//2.配置基本参数
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/mydb1");
		ds.setUser("root");
		ds.setPassword("123");
		//3.获取连接
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
}
