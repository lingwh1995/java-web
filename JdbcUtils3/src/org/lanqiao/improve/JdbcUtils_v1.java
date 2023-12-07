package org.lanqiao.improve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 使用配置文件,但是没有使用静态代码块优化的JdbcUtils
 * @author ronin
 *
 */
public class JdbcUtils_v1 {
	/* properties文件里面的格式:	key=value,换行时不加分号
	 * 若我们的配置文件为properties,并且放在src目录下.
	 * 我们可以通过ResourceBundle工具类快速的获取里面的配置信息
	 * 
	 */
	
	//使用步骤
	//1.获取ResurocesBunde对象
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");//只写文件名，不写后缀
	//2.通过ResuorceBundle对象获取配置信息
		//获取连接参数
		String driverClass = bundle.getString("driverClassName");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		//注册驱动
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	/**
	 * 释放资源
	 * @param conn 连接
	 * @param st 语句执行者
	 * @param rs 结果集
	 */
	public static void closeResource(Connection conn,Statement st,ResultSet rs)  {
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}
	/**
	 * 释放连接
	 * @param conn
	 */
	public static void closeConn(Connection conn) {
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//当对象为空，GC就可以回收这个对象
				conn = null;
			}
	}
	/**
	 * 释放语句执行者
	 * @param st
	 */
	public static void closeStatement(Statement st) {
		if(st!=null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//当对象为空，GC就可以回收这个对象
				st = null;
			}
	}
	/**
	 * 释放结果集
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//当对象为空，GC就可以回收这个对象
				rs = null;
			}
	}
}
