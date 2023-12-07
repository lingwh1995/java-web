package org.lanqiao.base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 演示使用Base64编码和解码
 * @author ronin
 *
 */
public class MyBase64 {
	public static void main(String[] args) throws IOException {
		String s = "Username";
		
		/**
		 * 演示编码
		 */
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String encode = base64Encoder.encode(s.getBytes("UTF-8"));
		System.out.println(encode);
		
		/**
		 * 演示解码
		 */
		BASE64Decoder base64Decoder = new BASE64Decoder();
		byte[] bytes = base64Decoder.decodeBuffer(encode);
		System.out.println(new String(bytes,"utf-8"));
	}
}
