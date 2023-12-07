package org.lanqiao.service;

import java.sql.SQLException;

import org.lanqiao.dao.UserDao;
import org.lanqiao.domain.User;

public class UserService {

	public User login(String username, String password) throws SQLException {
		// 调用dao层方法完成查询操作
		return new UserDao().getUserByNameAndPassword(username,password);
	}

}
