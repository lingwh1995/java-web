package org.lanqiao.dao;

public class Test {
	public static void main(String[] args) {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			throw new RuntimeException("Hello");
		}
	}
}
