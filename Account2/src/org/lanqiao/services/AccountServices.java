package org.lanqiao.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.lanqiao.dao.AccountDao;
import org.lanqiao.utils.JdbcUtils;
/**
 * 注意:要在services层开启事务,也就是当前层
 * @author ronin
 *
 */

public class AccountServices {
	/**
	 * 转账
	 * @param fromUser 转出方
	 * @param toUser 转入方
	 * @param money 金额
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void account(String fromUser, String toUser, String money) throws SQLException  {
		Connection conn = null;
		try{
			conn = JdbcUtils.getConnection();
		//1.开启事务
		conn.setAutoCommit(false);
		//2.执行操作
			// 调用dao层的方法完成转账操作
		AccountDao dao = new AccountDao();
			// 转出
			//为了保证dao层的conn和service层的conn是一个conn,这里采用参数向下传递的方式来解决这个问题
		System.out.println("-------------");
		//测试事务,发生异常,则回滚
		//int i = 1/0;
		System.out.println("-------------");
		dao.accountOut(conn,fromUser,money);
			// 转入
			//为了保证dao层的conn和service层的conn是一个conn,这里采用参数向下传递的方式来解决这个问题
		dao.accountIn(conn,toUser, money);
		//3.事务提交
		conn.commit();
		//4.注意:最终要释放资源
		JdbcUtils.closeConn(conn);
		}catch(Exception e){
			e.printStackTrace();
			//这个语句的作用是把异常抛出去，在发生异常的时候，让调用这个方法的那一层也可以发现这个异常
			//事务回滚
			conn.rollback();
			throw e;
			
			//注意:throw e;会终止程序,这个语句下面的语句无法执行，会报异常
		}
	}

}
