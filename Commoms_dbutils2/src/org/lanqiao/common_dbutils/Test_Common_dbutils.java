package org.lanqiao.common_dbutils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import org.lanqiao.domain.User;
import org.lanqiao.utils.DataSourceUtils;

/**
 * 测试Appached的Commons-utils方法
 * 	增、删、改、查(重点是查询方法)
 * @author ronin
 *
 */
public class Test_Common_dbutils {
	 
	/**
	 * 测试增加(插入)方法
	 * @throws SQLException
	 */
	@Test
	public void fun1() throws SQLException{
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?)";
		Object[] params = {"zs","123"};
		int insertCount = qr.update(sql,params);
		System.out.println(insertCount);
	}
	
	
	/**
	 * 测试删除方法
	 * @throws SQLException
	 */
	@Test
	public void fun2() throws SQLException{
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from user where username = ?";
		Object[] params = {"zs"};
		int deleteCount = qr.update(sql,params);
		System.out.println(deleteCount);
	}
	
	
	/**
	 * 测试修改方法
	 * @throws SQLException
	 */
	@Test
	public void fun3() throws SQLException{
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set username = ? ,password = ? where username = ?";
		Object[] params = {"zsss","ZSSS","zs"};
		int updateCount = qr.update(sql,params);
		System.out.println(updateCount);
	}
	
	
	/**
	 * 测试查询方法:查询单条数据
	 * 		BeanHander()<T>:把数据封装一个JavaBean中
	 * @throws SQLException
	 */
	@Test
	public void fun4() throws SQLException{
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ?";
		Object[] params = {"zs"};
		BeanHandler<User> rsh = new BeanHandler<>(User.class);
		User user = qr.query(sql, rsh,params);
		System.out.println(user);
	}
	
	
	/**
	 * 聚合函数查询:转换成Number类型,再把Number转换成我们需要的数据类型
	 * @throws SQLException
	 */
	@Test
	public void scalarHandler() throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写sql
		String sql = "select count(*) from emp";
		///3.执行省sql
		Object count = qr.query(sql,new ScalarHandler());
		/**
		 * 以下写法为错误写法，这里的返回值虽然是Object，但是一定不能强制转换成自己想要的数据类型，否则出错
		 * 但是可以转换为其本身的类型
		 */
//		Integer count = (Integer)qr.query(sql,new ScalarHandler());
		Number longCount = (Number)qr.query(sql,new ScalarHandler());
		int intCount = longCount.intValue();
		System.out.println(intCount);
	}
}
