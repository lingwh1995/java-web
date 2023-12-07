package org.lanqiao.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.entity.User;
import org.lanqiao.utils.DataSourceUtils;

public class UserDao {

	public User ValidateUserNameByObjectIsExist(String username) throws SQLException {
		//1.创建语句执行者
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//未使用limit进行sql调优
		//String sql = "select * from User where username = ?";
		//使用了limit进行sql调优:只查询一条数据,查找到了就不再继续查询
		String sql = "select * from User where username = ? limit 1";
		Object[] params = {username};
		//这一步别忘记了把参数传递进去
		return qr.query(sql, new BeanHandler<>(User.class),params);
	}

}
