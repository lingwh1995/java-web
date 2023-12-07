package org.lanqiao.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.domain.User;
import org.lanqiao.utils.DataSourceUtils;

public class UserDao {

	public User isExist(String username,String password) throws SQLException {
		//通过用户名和密码判断用户是否存在
		//创建queryrunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//编写sql
		String sql = "select * from user where username =? and password = ?";
		Object[] params = {username,password};
		User user = qr.query(sql, new BeanHandler<>(User.class),params);
		return user;
	}

}
