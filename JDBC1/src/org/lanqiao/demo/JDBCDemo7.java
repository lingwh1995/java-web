package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import org.junit.Test;

import com.mysql.jdbc.Driver;

/**
 * 
 * 演示mysql预编译
 *
 */
public class JDBCDemo7 {
	
	@Test
	public void function() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//String classDriverName = "com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/mydb1?useServerPrepStmts=true";
		//?useServerPrepStmts=true,设置mysql预处理为开启状态
		String username = "root";
		String password = "123";
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("数据库连接成功");			
		    ps = conn.prepareStatement("SELECT * FROM EMP");
		    rs = ps.executeQuery();
		    while(rs.next()) {
		    	System.out.println(rs.getString(1));
		    }
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			if(rs!=null) {rs.close();}
			if(ps!=null) {ps.close();}
			if(conn!=null) {ps.close();}
		}
	}
}
