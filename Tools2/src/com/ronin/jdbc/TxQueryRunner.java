package com.ronin.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;


/**
 * 工具类使用说明:
 * 	一个支持事务操作的appache公共类
 *  TxQueryRunner依赖的jar包:commons-dbutils-1.6.jar
 */

/**
 * TxQueryRunnerTest相对于QueryRunner而言:支持事务
 * 需要配合JdbcUtils使用(其底层使用JdbcUtils获取连接)
 * @author ronin
 *
 */

/**
 * QueryRunner的三个方法
 * update() -->insert、update、delete
 * query() -->select
 * batch() -->批处理
 * @author ronin
 *
 */
public class TxQueryRunner extends QueryRunner {

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int[] result = super.batch(con, sql, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
			throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T result = super.query(con, sql, rsh, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}
	
	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T result = super.query(con, sql, rsh);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int result = super.update(con, sql);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int result = super.update(con, sql, param);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int result = super.update(con, sql, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}
}
