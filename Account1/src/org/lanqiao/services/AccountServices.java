package org.lanqiao.services;

import java.sql.SQLException;

import org.lanqiao.dao.AccountDao;

public class AccountServices {
	/**
	 * 转账
	 * @param fromUser 转出方
	 * @param toUser 转入方
	 * @param money 金额
	 * @throws SQLException 
	 */
	public void account(String fromUser, String toUser, String money) throws SQLException {
		// 调用dao层的方法完成转账操作
		AccountDao dao = new AccountDao();
		// 转出
		dao.accountOut(fromUser,money);
		// 转入
		dao.accountIn(toUser,money);
	}

}
