package org.lanqiao.javamail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;


public class JavaMailDemo {
	
	/**
	 * 使用163邮箱发送不带有附件的邮件
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	@Test
	public void fun1() throws AddressException, MessagingException{
		//1.得到Session
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		     return new PasswordAuthentication("15291183358@163.com", "LRWQ959178");
		    }
		}; 
		Session session = Session.getInstance(props, auth);
		System.out.println(session);
		
		//2.创建mimemessage
		MimeMessage message = new MimeMessage(session);
			//设置发 件人
		message.setFrom(new InternetAddress("15291183358@163.com"));
			//设置收 件人
		message.setRecipients(RecipientType.TO, "2926517283@QQ.com");
			//设置抄送
		message.setRecipients(RecipientType.CC, "2926517283@QQ.com");
			//设置密送
		message.setRecipients(RecipientType.BCC, "2926517283@QQ.com");
		
			//设置邮件标题
		message.setSubject("工作安排");
			//设置邮件正文
		message.setContent("明天9点就来上班,别忘记了", "text/html;charset=utf-8");
		
		//3.发送邮件
		Transport.send(message);
	}
	
	
	/**
	 * 使用163邮箱发送带有附件的邮件
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws IOException 
	 */
	@Test
	public void fun2() throws AddressException, MessagingException, IOException{
		//1.得到Session
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("15291183358@163.com", "LRWQ959178");
			}
		}; 
		Session session = Session.getInstance(props, auth);
		System.out.println(session);
		
		//2.创建mimemessage
		MimeMessage message = new MimeMessage(session);
		//设置发 件人
		message.setFrom(new InternetAddress("15291183358@163.com"));
		//设置收 件人
		message.setRecipients(RecipientType.TO, "2926517283@QQ.com");
		//设置抄送
		message.setRecipients(RecipientType.CC, "2926517283@QQ.com");
		//设置密送
		message.setRecipients(RecipientType.BCC, "2926517283@QQ.com");
		
		//设置邮件标题
		message.setSubject("这是第一封使用java发出的邮件....");
		//设置邮件正文
		/**
		 * 发送带有附件的邮件
		 * 		当发送的邮件含有附的时候,邮件体就为多部件形式
		 * 		1.创建一个多部件的邮件MimeMultipart
		 * 			Mutiltipart是一个集合,用来装在多个主题部件
		 * 		2.我们需要创建两个主体部件,一个是文本内容的,另一个是附件德
		 * 			主体部件叫MimeBodyPart
		 * 		3.把MimeBodyPart设置为MimeMultipart的内容
		 */
			//创建多部件主体
		MimeMultipart list = new MimeMultipart();
		/**
		 * 部件1
		 */
			//创建主体部件
		MimeBodyPart part1 = new MimeBodyPart();
			//设置主体部件的内容
		part1.setContent("这是一封包含附件的垃圾邮件","text/html;charset=utf-8");
			//把主体部件添加到集合中
		list.addBodyPart(part1);
		
		
		/**
		 * 部件2
		 */
		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile(new File("D:/01.jpeg"));
			//设置附件名称(注意处理附件名称乱码问题)
		part2.setFileName(MimeUtility.encodeText("附件1.jpeg"));
		//把主体部件添加到集合中
		list.addBodyPart(part2);
		
		
			//把集合添加到邮件中
		message.setContent(list);
		
		
		//3.发送邮件
		Transport.send(message);
	}
	
	
	
}
