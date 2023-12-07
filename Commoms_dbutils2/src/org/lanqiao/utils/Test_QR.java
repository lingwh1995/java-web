package org.lanqiao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.lanqiao.domain.User;
import org.lanqiao.utils.DataSourceUtils;
import org.lanqiao.utils.QR;

/**
 * 测试自己写的QR对象(Appache的DBUtils的内部原理)
 * @author ronin
 *
 */
public class Test_QR {

	/**
	 * 测试update()方法:增、删、改
	 * @throws SQLException
	 */
	@Test
	public void fun1() throws SQLException{
		QR qr = new QR(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?)";
		Object[] params = {"aa","bb"};
		int update = qr.update(sql, params);
		System.out.println(update);
	}
	
	
	/**
	 * 测试query()方法:查询
	 * @return 
	 * @throws SQLException
	 */
	@Test
	public void fun2() throws SQLException{
		User user = load("ls");
		System.out.println(user);
	}
	public User load(Object args) throws SQLException{
		QR qr = new QR(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ?";
		Object[] params = {args};
		RsHandler<User> rh = new RsHandler<User>(){

			@Override
			public User handle(ResultSet rs) throws SQLException {
				if(!rs.next()) return null;
				User user = new User();
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
				return user;
			}
			
		};
		return (User)qr.query(sql, rh, params);
	}
}
