package org.lanqiao.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.lanqiao.entity.User;
import org.lanqiao.utils.DataSourceUtils;

public class UserDao {
	/**
	 * 添加用户 用户信息
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public int addUser(User user) throws SQLException {
		// 调用DBUtils
		//创建qr对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//编写sql
		String sql = "insert into user(username,password,email,name,sex,birthday) values(?,?,?,?,?,?)";
		Object[] params = {user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getSex(),user.getBirthday()};
		return qr.update(sql,params);
	}
}
