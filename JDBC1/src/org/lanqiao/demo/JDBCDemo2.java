package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * 演示JDBC增、删、改、查操作 
 * 注意：只是演示，并未对代码进行规范，下一个demo中对代码进行规范
 *
 */
public class JDBCDemo2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//获取连接
		String classDriverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb1";
		String username = "root";
		String password = "123";
		Class.forName(classDriverName);
		Connection conn = DriverManager.getConnection(url,username,password);
		System.out.println(conn);
		//对数据库进行操作
		Statement st = conn.createStatement();
		//增加操作
		//执行下面的语句，会返回一个整数，代表被影响的行数
//		int r = st.executeUpdate("INSERT INTO PERSON(ID,NAME,AGE) VALUES(2,'ls',11)");
//		int r1 = st.executeUpdate("INSERT INTO PERSON(ID,NAME,AGE) VALUES(3,'ww',16)");
		//更新操作
		int r2 = st.executeUpdate("UPDATE PERSON SET NAME = '祝英台' WHERE ID =1");
		//删除操作
		int r3 = st.executeUpdate("DELETE FROM PERSON  WHERE ID =3");
		System.out.println(r3);
		//查询操作
		ResultSet rs = st.executeQuery("SELECT * FROM EMP");
		//Result这个查询结果集有一个行光标
		System.out.println("员工编号"+"\t"+"员工姓名"+"\t"+"管理者"+"\t"+"职位");
		while(rs.next()) {
			String empNo = rs.getString("EMPNO");
			String ename = rs.getString("ENAME");
			String job = rs.getString("JOB");
			int mgr = rs.getInt("MGR");
			System.out.print(empNo+"\t");
			System.out.print(ename+"\t");
			System.out.print(mgr+"\t");
			System.out.print(job+"\t");
			System.out.println();
		}
		
		//关闭资源，后用的后关
		rs.close();
		st.close();
		conn.close();//这个必须关，因为每次执行都会耗费资源，如果不关闭，总有一次资源会耗费完
	}
}
