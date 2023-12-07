package org.lanqiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.utils.DataSourcesUtils;


public class AccountDao {

	/**
	 * 转出方
	 * @param conn 
	 * @param fromUser
	 * @param money
	 * @throws SQLException 
	 */
	public void accountOut( String fromUser, String money) throws SQLException {
		Connection conn= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1.创建连接
			conn = DataSourcesUtils.getConnection();
			//2.编写sql
			String sql = "update account set money = money - ? where name = ?";
			//3.创建语句执行者
			ps = conn.prepareStatement(sql);
			//4.设置参数
			ps.setString(1, money);
			ps.setString(2, fromUser);
			//5.执行sql
			int i = ps.executeUpdate();
			//6.处理
			System.out.println("出账:"+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//手动抛出异常
			throw e;
		}finally{
			DataSourcesUtils.closeResource(ps, rs);
		}
		
	}
	/**
	 * 转入方
	 * @param conn2 
	 * @param toUser 
	 * @param money
	 * @throws SQLException 
	 */
	public void accountIn( String toUser, String money) throws SQLException {
		Connection conn= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1.创建连接
			conn = DataSourcesUtils.getConnection();
			//2.编写sql
			String sql = "update account set money = money + ? where name = ?";
			//3.创建语句执行者
			ps = conn.prepareStatement(sql);
			//4.设置参数
			ps.setString(1, money);
			ps.setString(2, toUser);
			//5.执行sql
			int i = ps.executeUpdate();
			//6.处理
			System.out.println("入账:"+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//手动抛出异常
			throw e;
		}finally{
			DataSourcesUtils.closeResource(ps, rs);
		}
	}

}
