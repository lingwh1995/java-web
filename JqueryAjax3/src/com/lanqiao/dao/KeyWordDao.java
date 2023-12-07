package com.lanqiao.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.lanqiao.utils.DataSourceUtils;


public class KeyWordDao {

	public List<Object> findKw4Ajax(String keyword) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select kw from keyword where kw like ? limit 5";
		Object[] params = {"%"+keyword+"%"};
		return qr.query(sql, new ColumnListHandler("kw"),params );
	}

}
