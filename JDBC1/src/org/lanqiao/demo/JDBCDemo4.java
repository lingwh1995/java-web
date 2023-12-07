package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.junit.Test;

import com.mysql.jdbc.Driver;

/**
 * 
 * JDBC增强，补充，演示ReslutSet中的方法
 *
 */
public class JDBCDemo4 {
	@Test
	public void function() throws Exception{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//准备JDBC四大参数
			String classDriverName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mydb1";
			String username = "root";
			String password = "123";
			//加载JDBC驱动
			//Class.forName(classDriverName);
			//注册JDBC驱动
			Driver driver = new Driver();//获取驱动(导入的是JDBC包)
			DriverManager.registerDriver(driver);//注册驱动
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("数据库连接已经获取");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM EMP");//返回查询结果集
			/*
			 * JDBC增强
			 * 获取元数据：rs.getMetaData，返回值为ResultMetaData();
			 * 获取结果集列数：int getColumnCount()
			 * 获取指定的列名：String getColumnName(int ColumnIndex)
			 */
			//获取元数据结果集，元数据结果集里面有列数目
			ResultSetMetaData metaData = rs.getMetaData();//获取元数据结果集
			int count = metaData.getColumnCount();//获取数据总行数
		    System.out.println("记录的总列数是："+count);
		    //下一步，遍历行列，输出表格样式数据
		    while(rs.next()) {//外循环遍历行		    	
		    	for (int i = 1; i <= count; i++) {//内循环遍历遍历列，注意：这里i从1开始，不是从0开始
		    		System.out.print(rs.getString(i));//
		    		if(i < count) {
		    			System.out.print("\t");
		    		}
				}
		    	System.out.println();	
		    }
		} catch (Exception e) {
			throw new RuntimeException();//抛出一个运行时异常，Runtime中t小写不是大写
		}finally {
				if(rs!=null) {rs.close();}
				if(st!=null) {st.close();}
				if(conn!=null) {conn.close();}
		}
	}
}
