package org.lanqiao.demo;

public class JDBCDemo1 {
	public static void main(String[] args) {
		//数据库类型与java中类型的对应关系
		/*
		 * DATE --> java.sql.Date
		 * TIME --> java.sql.Time
		 * TIMESTAMP --> java.sql.TimeStamp
		 */
		//时间类型的转换
		//java.util.Date --> java.sql.Date、Time、Timestamp
			//把util的Date转换成毫秒值
			//使用毫秒值创建的Date
		//java.sql.Date、Time、TimeStamp  -->java.util.Date
			//这一步不需要处理：因为 java.sql.Date是java.util.Date
		java.util.Date date = new java.util.Date();
		long l = date.getTime();
		java.sql.Date sqlDate = new java.sql.Date(l);
	}
}
