package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 * 演示MySql的批处理
 * @author ronin
 *
 */
public class JDBCDemo3 {
	public static void main(String[] args) {
		/*
		 * ps对象内部有集合
		 * 1.使用循环向ps中添加sql参数，使用一组参数与模板就可以匹配出一条sql语句
		 * 2.调用执行批处理的方法，完成向数据库中发送sql语句
		 */
		String driver = "com.mysql.jdbc.Driver";
		//打开mysql批处理 		?rewriteBatchedStatements\=true
		String url = "jdbc:mysql://localhost:3306/mydb1?rewriteBatchedStatements=true";
		String username = "root";
		String password = "123";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println(conn);
			String sql = "insert into person values(?,?,?)";
			ps = conn.prepareStatement(sql);
			//疯狂添加参数
			for(int i=0;i<1000;i++) {
				ps.setInt(1, i);
				ps.setString(2, "per_"+i);
				ps.setInt(3, i);
				//添加批处理，这一组参数就保存到集合中了
				ps.addBatch();
			}
			long start = System.currentTimeMillis();
//			ps.executeUpdate();//执行批添加不能用这个语句，要用下面的语句
			ps.executeBatch();
			long end = System.currentTimeMillis();
			System.out.println((end-start)/1000);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
