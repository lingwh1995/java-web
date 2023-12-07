package org.lanqiao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;



public class TestJdbcUtils {
	//插入一条数据
	@Test
	public void fun1() {
		//获取连接
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			String sql = "insert into user values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "ww");
			ps.setInt(2, 15);
			int i = ps.executeUpdate();
			//处理结果集
			if(i==1) {
				System.out.println("成功");
			}else {
				System.out.println("失败");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, ps, rs);
		}
	}
}
