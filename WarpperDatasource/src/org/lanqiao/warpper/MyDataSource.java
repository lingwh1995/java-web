package org.lanqiao.warpper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 自定义一个简易的连接池
 * 注意:连接池中的连接也是通过jdbc去获取的
 * @author ronin
 *
 */
public class MyDataSource {
	/*
	 * 连接池概述:用来管理数据库中的连接，就在所在连接池初始化的时候存入一定的连接池，用的时候通过方法获取，不用的时
	 */
	static LinkedList<Connection> pool = new LinkedList<>();
	//所谓的初始化，通常有两种方式来实现，静态代码块或者构造方法
	static {
		//初始化的时候需要放入三个连接
		for(int i=0;i<3;i++) {
			try {
				Connection conn = JDBCUtils.getConnection();
				pool.addLast(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//获取连接
	public static Connection getConnection() {
		//注意:huoqu8连接的时候要判断pool是否为空
		if(pool.isEmpty()) {
			for(int i=0;i<3;i++) {
				try {
					Connection conn = JDBCUtils.getConnection();
					pool.addLast(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("从连接池中获取了一个连接....");
		//将conn进行包装
		 Connection conn = pool.removeFirst();
		ConnectionWripper myConn = new ConnectionWripper(conn,pool);
		return myConn;
	}
	
	//归还连接的方法
	public  static void addBack(Connection conn) {
		//将conn放入到list的最后
		pool.addLast(conn);
		System.out.println("连接已归还....");
	}
}
