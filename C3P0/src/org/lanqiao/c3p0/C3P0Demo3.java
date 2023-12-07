package org.lanqiao.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 *演示C3P0的构造器指定命名配置元素的名称(Oracle)
 *演示C3P0的命名配置
 * @author ronin
 *
 */
//注意:mysql不需要导入驱动，oracle需要导入jar包
public class C3P0Demo3 {
	public static void main(String[] args) throws SQLException {
		//<named-config name="oracle-config">
		ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle-config");
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		//把连接归还给池
		conn.close();
	}
}
