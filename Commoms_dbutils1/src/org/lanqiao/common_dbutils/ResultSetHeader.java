package org.lanqiao.common_dbutils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

/**
 * 演示使用dbutils进行r操作
 * @author ronin
 *
 */
public class ResultSetHeader {
	
	/**
	 * ArrayHandler：将查询结果的第一条封装成数组返回
	 * @throws SQLException
	 */
	@Test
	public void arrayHandler() throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写sql
		String sql = "select * from emp";
		///3.执行省sql
		Object[] query = qr.query(sql,new ArrayHandler());
		System.out.println(Arrays.toString(query));
	}
	
	/**
	 * ArrayListHandler：将查询结果的每一条封装成数组，再把数组放到List中返回
	 * @throws SQLException
	 */
	@Test
	public void arrayListHandler() throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写sql
		String sql = "select * from emp";
		///3.执行省sql
		List<Object[]> query = qr.query(sql,new ArrayListHandler());
		for(Object[] obj:query) {
			System.out.println(Arrays.toString(obj));
		}
	}
	/**
	 * BeanHandler：将查询结果的每一条记录封装成指定的bean对象，返回
	 * @throws SQLException
	 */
	@Test
	public void beanHandler() throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写sql
		String sql = "select * from user";
		///3.执行省sql
		User user = qr.query(sql,new BeanHandler<>(User.class));
		System.out.println(user.toString());
	}
	/**
	 * BeanListHandler：将查询结果的每一条记录封装成指定的bean对象，把每一个bean对象放入list中，返回
	 * @throws SQLException
	 */
	@Test
	public void beanListHandler() throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写sql
		String sql = "select * from user";
		///3.执行省sql
		List<User> userList = qr.query(sql,new BeanListHandler<>(User.class));
		for(User u:userList) {
			System.out.println(u.toString());
		}
	}
	/**
	 * MapHandler：将查询结果的第一条记录封装map,返回
	 * @throws SQLException
	 */
	@Test
	public void mapHandler() throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写sql
		String sql = "select * from emp";
		///3.执行省sql
		Map<String, Object> map = qr.query(sql,new MapHandler());
		System.out.println(map);
	}
	/**
	 * MapListHandler：将查询结果的每一条记录封装成map,把每一个map放入到List中返回
	 * @throws SQLException
	 */
	@Test
	public void mapListHandler() throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写sql
		String sql = "select * from emp";
		///3.执行省sql
		List<Map<String, Object>> mapList = qr.query(sql,new MapListHandler());
		for (Map<String, Object> map : mapList) {
			System.out.println(map);
		}
	}
	/**
	 * ScalarHandler：将查询结果的每一条记录封装成map,把每一个map放入到List中返回
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
		Number longCount = (Long)qr.query(sql,new ScalarHandler());
		System.out.println(longCount);
		//那么如何查看这个返回值的数据类型呢？
		System.out.println("全类名："+count.getClass().getName());
		System.out.println(count);
	}
}
