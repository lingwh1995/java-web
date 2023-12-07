package org.lanqiao.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 使用外部配置文件
 * 配置文件的默认配置
 *
 */
//注意:mysql不需要导入驱动，oracle需要导入jar包
public class C3P0Demo2 {
	public static void main(String[] args) throws SQLException {
		/**
		 * 在创建连接池对象的时候，这个对象就会自动加载配置文件，不用我们来指定
		 */
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection conn = dataSource.getConnection();
		
		System.out.println(conn);
		//把连接归还给池
		conn.close();
	}
}
