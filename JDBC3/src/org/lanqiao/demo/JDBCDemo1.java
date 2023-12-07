package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * 本类演示JDBC操作数据库完成查询数据
 *
 */
public class JDBCDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		//1.导入所需要的jar包
		//2.加载数据库驱动
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//3.创建立数据库连接
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			conn = DriverManager.getConnection(url,user,password);
			//4.创建需要使用的数据操作对象
			/*
			 * Statement:构建常规的SQL并执行
			 * PrepareState:构建可以被编译的SQL并执行
			 */
			/*
			//方式一：Statement st = conn.createStatement();
			Statement st = conn.createStatement();
			//5.数据库的操作
//			ResultSet rs = st.executeQuery("SELECT * FROM EMP");
//			ResultSet rs = st.executeQuery("SELECT * FROM EMP WHERE ENAME='SCOTT'");
			ResultSet rs = st.executeQuery("SELECT * FROM EMP WHERE ENAME='SCOTT' AND EMPNO=7788");
			*/
			//方式二
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EMP WHERE EMPNO = ?");
			ps.setInt(1, 7788);
			ResultSet rs = ps.executeQuery();
			//方式二比方式一好一点，方式二可以自定义条件
			//6.处理结果，使用next()方法:移动结果集中的指针，从而获取数据
			while(rs.next()) {
				String eName = rs.getString("ENAME");
				int empNo = rs.getInt("EMPNO");
				System.out.println(empNo+"------"+eName);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7.关闭连接
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
