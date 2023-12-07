package org.lanqiao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:orcl" ;//mysql3306  sqlserver1433
	private final static String USERNAME = "scott";
	private final static String PASSWORD = "tiger";
	private static ResultSet rs = null;
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	
	public static ResultSet getRs() {
		return rs;
	}
	public static Connection getConn() {
		return conn;
	}
	public static PreparedStatement getPs() {
		return ps;
	}
	public static PreparedStatement getPreparedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		ps = conn.prepareStatement(sql);
		if(params !=null){
			 for(int i=0;i<params.length;i++){
				 ps.setObject(i+1, params[i]);
			 }
		 }
		return ps;
	}
	//增删改
	public static boolean executeUpdate(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		ps = getPreparedStatement(sql,params);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				ps.setObject((i+1), params[i]);
			}
		}
		int result = ps.executeUpdate();
		if(result>0) {
			flag = true;
		}
		closeAll(null, ps, conn);
		return flag;
	}
	
	public static ResultSet executQuery(String sql,Object[] params) throws ClassNotFoundException, SQLException{
		ps = getPreparedStatement(sql,params);
	    rs = ps.executeQuery();	
	
		//为了实现通用，查询时直接返回ResultSet，而且不能进行关闭
		return rs;
	}
	
	//查询
	public static void closeAll(ResultSet rs,Statement st,Connection conn) {
		try {
			if(st!=null) st.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//查询总数据量
	public static int getToalCount(String sql) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		int count = -1;
		if(rs.next()) {
			 count = rs.getInt(1);
		}
		return count;
	}
}
