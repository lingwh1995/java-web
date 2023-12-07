package org.lanqiao.common_dbutils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

/**
 * appache-dbutils入门demo
 * 演示使用dbutils进行cud操作
 * @author ronin
 *
 */
public class DBUtilsDemo1 {
	@Test
	public void insert() throws SQLException {
		//1.创建queryRunner类
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写sql
		String sql = "insert into user values(?,?)";
		//3.执行sql
		Object[] params = {"zss",20};
		int count = qr.update(sql,params);
		System.out.println(count);
	}
	@Test
	public void update() throws SQLException {
		//1.创建queryRunner类
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写sql
		String sql = "update user set username = ? where password= ?";
		Object[] params = {"uypdate",15};
		//3.执行sql
		int update = qr.update(sql,params);
		System.out.println(update);
	}
}
