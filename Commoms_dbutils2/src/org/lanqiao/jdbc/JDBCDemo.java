package org.lanqiao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.lanqiao.domain.User;
import org.lanqiao.utils.DataSourceUtils;

/**
 * 演示使用DataSourceUtils获取连接,然后操作数据库,完成增、删、改、查操作
 * @author ronin
 */

public class JDBCDemo {
	
	/**
	 * 查询表中全部数据 
	 * @throws SQLException
	 */
	@Test
	public void fun1() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DataSourceUtils.getConnection();
			ps = conn.prepareStatement("select * from emp");
			rs = ps.executeQuery();
			//获取查询结果并处理查询结果
			while(rs.next()){
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				System.out.println(empno+"---"+ename);
			}
		} catch (Exception e) {
			throw new RuntimeException();//抛出一个运行时异常
		}finally {
			//进行排空的原因是因为如果上面的代码没有获取到rs、st、conn这个三个对象，在这里就会产生一个空指针异常
			if(rs!=null) rs.close();					
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
	}
	
	
	/**
	 * 根据条件查询表中数据 
	 * @throws SQLException
	 */
	@Test
	public void fun2() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DataSourceUtils.getConnection(); 
			ps = conn.prepareStatement("select * from emp where empno = ?");
			//设置查询条件
			ps.setInt(1, 7369);
			//获取查询结果并处理查询结果
			rs = ps.executeQuery();
			while(rs.next()){
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				System.out.println(empno+"---"+ename);
			}
		} catch (Exception e) {
			throw new RuntimeException();//抛出一个运行时异常
		}finally {
			//进行排空的原因是因为如果上面的代码没有获取到rs、st、conn这个三个对象，在这里就会产生一个空指针异常
			if(rs!=null) rs.close();					
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
	}
	
	/**
	 * 根据条件查询表中数据,并将数据封装到JavaBean中
	 * @throws SQLException
	 */
	@Test
	public void fun3() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DataSourceUtils.getConnection(); 
			ps = conn.prepareStatement("select * from user where username = ?");
			//设置查询条件
			ps.setString(1, "ls");
			//获取查询结果并处理查询结果
			rs = ps.executeQuery();
			/**
			 * 把数据封装到JavaBean中
			 */
			User user = new User();
			if(rs.next()){
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			System.out.println(user);
		} catch (Exception e) {
			throw new RuntimeException();//抛出一个运行时异常
		}finally {
			//进行排空的原因是因为如果上面的代码没有获取到rs、st、conn这个三个对象，在这里就会产生一个空指针异常
			if(rs!=null) rs.close();					
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
	}
	
	
	/**
	 * 增加数据 
	 * @throws SQLException
	 */
	@Test
	public void fun4() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DataSourceUtils.getConnection(); 
			ps = conn.prepareStatement("insert into user values(?,?)");
			//设置增加数据的条件
			ps.setString(1, "zs");
			ps.setInt(2, 888);
			//查询受影响的记录条数
			int count = ps.executeUpdate();
			System.out.println("受影响的记录条数:"+count);
		} catch (Exception e) {
			throw new RuntimeException();//抛出一个运行时异常
		}finally {
			//进行排空的原因是因为如果上面的代码没有获取到rs、st、conn这个三个对象，在这里就会产生一个空指针异常
			if(rs!=null) rs.close();					
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
	}
	
	
	/**
	 * 删除数据 
	 * @throws SQLException
	 */
	@Test
	public void fun5() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DataSourceUtils.getConnection(); 
			ps = conn.prepareStatement("delete from user where username = ?");
			//设置删除条件
			ps.setString(1, "zs");
			//查询受影响的记录条数
			int count = ps.executeUpdate();
			System.out.println("受影响的记录数:"+count);
		} catch (Exception e) {
			throw new RuntimeException();//抛出一个运行时异常
		}finally {
			//进行排空的原因是因为如果上面的代码没有获取到rs、st、conn这个三个对象，在这里就会产生一个空指针异常
			if(rs!=null) rs.close();					
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
	}
	
	
	/**
	 * 修改数据 
	 * @throws SQLException
	 */
	@Test
	public void fun6() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DataSourceUtils.getConnection(); 
			ps = conn.prepareStatement("update user set username = ? ,password = ? where username = ?");
			//设置修改条件
			ps.setString(1, "修改后的username");
			ps.setString(2, "修改后的password");
			ps.setString(3, "zss");
			//查询受影响的记录条数
			int count = ps.executeUpdate();
			System.out.println("受影响的记录数:"+count);
		} catch (Exception e) {
			throw new RuntimeException();//抛出一个运行时异常
		}finally {
			//进行排空的原因是因为如果上面的代码没有获取到rs、st、conn这个三个对象，在这里就会产生一个空指针异常
			if(rs!=null) rs.close();					
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}
	}
}
