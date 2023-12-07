package org.lanqiao.services;

import java.sql.SQLException;

import org.lanqiao.dao.AccountDao;
import org.lanqiao.utils.DataSourcesUtils;
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
		AccountDao dao = new AccountDao();
		try{
		//1.开启事务
		DataSourcesUtils.startTransaction();
		//1.转出
		dao.accountOut(fromUser, money);
		
		//若此处发生错误,则会出发事务回滚
		//int i = 1/0;
		
		
		
		//2.转入
		dao.accountIn(toUser,money);
		//4.事务提交+释放资源
		DataSourcesUtils.commitAndCloseTransaction();
		}catch(Exception e){
			e.printStackTrace();
			//这个语句的作用是把异常抛出去，在发生异常的时候，让调用这个方法的那一层也可以发现这个异常
			//事务回滚
			DataSourcesUtils.rollbacktAndCloseTransaction();
			throw e;
			
			//注意:throw e;会终止程序,这个语句下面的语句无法执行，会报异常
		}
	}

}
