package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 
 * JDBC代码规范化(标准的JDBC代码)
 *
 */
public class JDBCDemo3 {
	@Test
	public void function() throws Exception{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String classDriverName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mydb1";
			String username = "root";
			String password = "123";
			Class.forName(classDriverName);//注意：Class中C是大写，不是小写
			conn = DriverManager.getConnection(url,username,password);	
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM EMP");
			System.out.println("--------------------");
			rs.last();//把光标移动到最后一行
			System.out.println(rs.getRow());//返回当前光标所在行是第几行
			//这两个方法要配合可以统计总行数有多少行，但是执行完之后光标就到了最后一行
			rs.beforeFirst();//如果还有遍历光标，就要把光标再移动到第一行之前
			//API中输入ResultSetj即可查询所有方法
			System.out.println("--------------------");
			while(rs.next()) {
				String empNo = rs.getString("EMPNO");
				System.out.println(empNo);
			}
		} catch (Exception e) {
			throw new RuntimeException();//抛出一个运行时异常
		}finally {
				//进行排空的原因是因为如果上面的代码没有获取到rs、st、conn这个三个对象，在这里就会产生一个空指针异常
				if(rs!=null) rs.close();					
				if(st!=null) st.close();
				if(conn!=null) conn.close();
		}
	}
}
