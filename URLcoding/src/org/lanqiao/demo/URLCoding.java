package org.lanqiao.demo;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * 演示URL编码解码原理
 * @author ronin
 *
 */
public class URLCoding {
	public static void main(String[] args) {
		/*
		 * URL编码
	　　表单的类型：Content-Type: application/x-www-form-urlencoded，就是把中文转换成%后面跟随两位的16进制。
	　　为什么要用它：在客户端和服务器之间传递中文时需要把它转换成网络适合的方式。
	
	　　* 它不是字符编码！
	　　* 它是用来在客户端与服务器之间传递参数用的一种方式！
	　　* URL编码需要先指定一种字符编码，把字符串解码后，得到byte[]，然后把小于0的字节+256，再转换成16进制。前面再添加一个%。
	　　* POST请求默认就使用URL编码！tomcat会自动使用URL解码！
	　　* URL编码：String username = URLEncoder.encode(username, "utf-8");
	　　* URL解码：String username = URLDecoder.decode(username, "utf-8");
	
	　　最后我们需要把链接中的中文参数，使用url来编码！今天不行，因为html中不能给出java代码，但后面学了jsp就可以了。
		 */
		String name = "张三";
//		byte[] bs = name.getBytes();
//		System.out.println(Arrays.toString(bs));
		//编码
		String encode = URLEncoder.encode(name);
		System.out.println(encode);
		System.out.println("--------------------");
		//解码
		String decode = URLDecoder.decode(encode);
		System.out.println(decode);
		
		//用途：把超链接中的中文编码，使得中文可以安全的在网络中传输
	}
}
