package org.lanqiao.demo;
/**
 * 
 * 本类演示JDBC操作数据库完成增、删、改操作
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JBDCDemo2{
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//1.导入所需要的jar包
			//2.加载数据库驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//3.创建连接
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url,user,password);
			//3.创建数据库操作对象
			PreparedStatement ps = conn.prepareStatement("insert into t(id,name) values(?,?)");
			ps.setInt(1, 2);
			ps.setString(2, "lisi");
			//4.执行操作
			ps.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
