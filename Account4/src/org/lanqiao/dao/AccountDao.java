package org.lanqiao.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
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
		//1.创建queryrunner对象
		QueryRunner qr = new QueryRunner();
		//2.编写sql
		String sql = "update account set money = money - ? where name = ?";
		//3.设置参数
		Object[] params = {money,fromUser};
		//4.执行sql
		int update = qr.update(DataSourcesUtils.getConnection(),sql,params);
		System.out.println(update);
	}
	
	
	/**
	 * 转入方
	 * @param conn2 
	 * @param toUser 
	 * @param money
	 * @throws SQLException 
	 */
	public void accountIn( String toUser, String money) throws SQLException {
		//1.创建queryrunner对象
		QueryRunner qr = new QueryRunner();
		//2.编写sql
		String sql = "update account set money = money + ? where name = ?";
		//3.设置参数
		Object[] params = {money,toUser};
		//4.执行sql
		int update = qr.update(DataSourcesUtils.getConnection(),sql,params);
		System.out.println(update);
	}	

}
