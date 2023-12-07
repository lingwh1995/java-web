package org.lanqiao.services;

import java.sql.SQLException;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;

public class UserServices {
	
	public int regist(User user) throws SQLException {
		// 调用dao
		UserDao dao = new UserDao();
		return dao.addUser(user);
	}

}
