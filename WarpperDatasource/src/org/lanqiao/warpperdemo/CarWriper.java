package org.lanqiao.warpperdemo;

/**
 * 装饰者模式
 * @author ronin
 *
 */
public class CarWriper implements Car{

	
	private Car car;
	
	//通过构造方法获取被装饰对象的引用
	public CarWriper(Car car) {
		this.car = car;
	}

	@Override
	public void run() {
		System.out.println("加上电池...");
		System.out.println("我终于可以5秒过百了.....");
		
	}

	@Override
	public void stop() {
		car.stop();
	}

}
