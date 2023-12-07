package org.lanqiao.warpperdemo;

public class TestWripperQQ {
	public static void main(String[] args) {
		QQ qq = new QQ();
		CarWriper wriper = new CarWriper(qq);
		wriper.run();
		wriper.stop();
	}
}
