package org.lanqiao.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.domain.User;
import org.lanqiao.utils.DataSourcesUtils;

public class UserDao {

	public User getUserByNameAndPassword(String username, String password) throws SQLException {
		//1.创建语句执行者
		QueryRunner qr = new QueryRunner(DataSourcesUtils.getDataSource());
		//2.编写sql(注意:这里要进行sql语句优化)
		String sql = "select * from user where username = ? and password = ? limit 1";
		Object[] params = {username,password}; 
		//3.执行sql并返回查询结果
		return qr.query(sql, new BeanHandler<>(User.class),params);
	}

}
