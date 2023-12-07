package org.lanqiao.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.entity.User;
import org.lanqiao.utils.DataSourcesUtils;

public class UserDao {

	public User queryUserByName(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourcesUtils.getDataSource());
		//未使用limit进行sql调优
		//String sql = "select * from User where username = ?";
		//使用了limit进行sql调优:只查询一条数据,查找到了就不再继续查询
		String sql = "select * from user where username = ? limit 1";
		Object[] params = {username};
		//这一步别忘记了把参数传递进去
		User user = qr.query(sql, new BeanHandler<>(User.class),params);
		return user;
	}

}
