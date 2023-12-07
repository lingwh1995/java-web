package org.lanqiao.services;

import java.sql.SQLException;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;

public class UserServices {

	public User ValidateUserNameByObjectIsExist(String username) throws SQLException {
		// TODO Auto-generated method stub
		return new UserDao().ValidateUserNameByObjectIsExist(username);
	}

}
