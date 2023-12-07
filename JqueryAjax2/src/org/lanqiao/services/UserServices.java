package org.lanqiao.services;


import java.sql.SQLException;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;

public class UserServices {

	public User queryUserByName(String username) throws SQLException  {
		return new UserDao().queryUserByName(username);
	}



}
