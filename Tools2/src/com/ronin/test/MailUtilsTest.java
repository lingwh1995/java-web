package com.ronin.test;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;

import org.junit.Test;

import com.ronin.mail.Mail;
import com.ronin.mail.MailUtils;

/**
 * 测试使用MailUtils发送邮件
 * @author ronin
 *
 */
public class MailUtilsTest {
	
	@Test
	public void send() throws MessagingException, IOException{
		/*
		 * 1.登录邮件服务器
		 * 		MailUtils.createSession(服务器地址,登录名,密码);
		 * 2.创建邮件对象
		 * 		发件人
		 * 		收件人
		 * 		主题
		 * 		正文
		 * 3.发邮件
		 */
		//1.登录邮件服务器
		Session session = MailUtils.createSession("smtp.163.com", "15291183358@163.com", "LRWQ959178");
		//2.创建邮件对
		Mail mail = new Mail("15291183358@163.com","1458687169@QQ.com","工作安排","明天早上九点准时上班,别忘记了.");
		//3.发送邮件
		MailUtils.send(session, mail);
	}
}
