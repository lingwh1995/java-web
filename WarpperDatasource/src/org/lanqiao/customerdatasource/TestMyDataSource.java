package org.lanqiao.customerdatasource;

import java.sql.Connection;

public class TestMyDataSource {
	public static void main(String[] args) {
		//创建连接池对象
		MyDataSource ds = new MyDataSource();
		//获取连接
		Connection conn = ds.getConnection();
		System.out.println(conn);
		//归还连接
		ds.addBack(conn);
	}
}
