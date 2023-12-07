package org.lanqiao.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCDemo4 {
	/**
	 * 一个非常标准的连接Oracle数据库的示例代码
	 */
	public static void main(String[] args) {
		Connection conn = null;// 创建一个数据库连接
		PreparedStatement ps = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		ResultSet rs = null;// 创建一个结果集对象
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
			System.out.println("开始尝试连接数据库！");
			String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
			String user = "scott";// 用户名,系统默认的账户名
			String password = "tiger";// 你安装时选设置的密码
			conn = DriverManager.getConnection(url, user, password);// 获取连接
			System.out.println("连接成功！");
			String sql = "SELECT * FROM EMP";// 预编译语句，“？”代表参数
			ps = conn.prepareStatement(sql);// 实例化预编译语句
			rs = ps.executeQuery();// 执行查询，注意括号中不需要再加参数
			while (rs.next())
				// 当结果集不为空时
				System.out.println(rs.getString("ENAME"));
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}finally {
			try {
				// 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
				// 注意关闭的顺序，最后使用的最先关闭
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
				System.out.println("数据库连接已关闭！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
