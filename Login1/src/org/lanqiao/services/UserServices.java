package org.lanqiao.services;

import java.sql.SQLException;

import org.lanqiao.dao.UserDao;
import org.lanqiao.domain.User;

public class UserServices {
	/**
	 * 用户登录方法
	 * @param username 用户名
	 * @param password 密码
	 * @return User 用户
	 * @throws SQLException 
	 */
	public User login(String username, String password) throws SQLException {
		//调用dao
		UserDao dao = new UserDao();
		return dao.isExist(username,password);
	}

}
