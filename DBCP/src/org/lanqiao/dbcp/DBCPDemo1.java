package org.lanqiao.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

/**
 * DBCP:appach组织的产品
 * @author ronin
 * 使用步骤:
 * 	1.导入jar包，build path
 * 	2.使用API
 * 		a.硬编码
 * 		b.使用配置文件
 *
 */
/**
 * 演示硬编码的DBCP
 * @author ronin
 *
 */
public class DBCPDemo1 {
	
	@Test
	public void fun1() throws SQLException {
		//1.创建连接池
		BasicDataSource ds = new BasicDataSource();
		//2.配置连接信息
		ds.setDriverClassName("com.mysql.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/mydb1");
		ds.setUrl("jdbc:mysql:///mydb1");
		ds.setUsername("root");
		ds.setPassword("123");
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
}
