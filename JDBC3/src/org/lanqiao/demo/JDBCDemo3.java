package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * //演示事物和回滚操作
 *
 */
public class JDBCDemo3 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//1.导入jar包
			//2.加载数据库驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//3.创建连接
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			conn = DriverManager.getConnection(url,user,pwd);
			//4.创建数据库操作对象
			//要使用事物，首先要确保自动事物处于关闭状态
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES(?, ?, ?)");
			ps.setInt(1, 50);
			ps.setString(2, "New Dept");
			ps.setString(3, "New York");
			ps.execute();
			ps = conn.prepareStatement("INSERT INTO EMP(EMPNO, ENAME, JOB, MGR,HIREDATE, SAL, COMM, DEPTNO) VALUES(?, ?, ?,?, ?, ?, ?, ?)");
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO EMP(EMPNO, ENAME, JOB, MGR,HIREDATE, SAL, COMM, DEPTNO) VALUES(?, ?, ?,?, ?, ?, ?, ?)");
			ps.setInt(1, 7802);			
			ps.setString(2, "TOMCAT");
			ps.setString(3, "CLERK");
			ps.setInt(4, 7788);
			ps.setString(5, "23-1月-82");//插入日期也用setString()方法
			ps.setInt(6, 2500);
			ps.setInt(7, 0);
			ps.setInt(8, 50);	
			//5.执行插入数据操作
			conn.commit();
			ps.execute();
			//6.循环遍历获取每一条数据
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
