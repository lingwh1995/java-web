package org.lanqiao.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * 演示把MP3格式的数据存储到MySql中，演示存储大数据
 * 数据库建表语句：
 * CREATE TABLE tab_bin(
	id INT PRIMARY KEY AUTO_INCREMENT,
	filename VARCHAR(200),
	DATA MEDIUMBLOB
	)
 *
	max_allowed_packet = 10485760
 */
	public class JDBCDemo2 {
		@Test
		public void fun1() {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mydb1";
			String username = "root";
			String password = "123";
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,username,password);
				String sql = "insert into tab_bin values(?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, 2);
				ps.setString(2, "齐豫 - 橄榄树.mp3");
				byte[] bs = IOUtils.toByteArray(new FileInputStream("d:/齐豫 - 橄榄树.mp3"));
				Blob bolb =	new SerialBlob(bs); 
				ps.setBlob(3, bolb);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(ps!=null) ps.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}catch (Exception e2) {
				}
			}
			
		}
		
		
		@Test
		public void fun2() {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mydb1";
			String username = "root";
			String password = "123";
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs =null;
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,username,password);
				String sql = "select * from tab_bin";
				ps = conn.prepareStatement(sql);
				/*
				 * 3. pstmt执行查询，得到ResultSet
				 */
				rs = ps.executeQuery();
				
				/*
				 * 4. 获取rs中名为data的列数据
				 */
				if(rs.next()) {
					Blob blob = rs.getBlob("data");
					/*
					 * 把Blob变成硬盘上的文件！
					 */
					/*
					 * 1. 通过Blob得到输入流对象
					 * 2. 自己创建输出流对象
					 * 3. 把输入流的数据写入到输出流中
					 */
					InputStream in = blob.getBinaryStream();
					OutputStream out = new FileOutputStream("d:/lgfw.mp3");
					IOUtils.copy(in, out);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(ps!=null) ps.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}catch (Exception e2) {
				}
			}
			
		}
	}
	
