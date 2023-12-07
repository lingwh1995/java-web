package org.lanqiao.dbcp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DBCPDemo2 {
	@Test
	public void fun1() throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/dbcp.properties"));
		DataSource ds = new BasicDataSourceFactory().createDataSource(prop);
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
}
