package org.lanqiao.threadlocal;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ThreadLocalDemo1 {
	@Test
	public void fun1(){
		ThreadLocal<String> tl = new ThreadLocal<String>();
		/**
		 * 存放:当前线程做map的键
		 */
		tl.set("Hello");
		tl.set("World");
		System.out.println("当前线程获取:"+tl.get());
		//删除
//		tl.remove();
//		System.out.println("当前线程获取:"+tl.get());
		
		
		/**
		 * 使用内部类获取存放在ThreadLocal中的类
		 */
		new Thread() {
			
			public void run(){
				System.out.println("-------------------");
				System.out.println("内部类线程获取:"+tl.get());
				System.out.println("-------------------");
			}
		}.start();
	}
}

/**
 * 内部原理
 */
class TL<T>{
	//线程做键,T类型的数据做值
	private Map<Thread,T> map = new HashMap<Thread,T>();
	
	public void set(T data){
		map.put(Thread.currentThread(), data);
	}
	
	public T get(T data){
		return map.get(Thread.currentThread());
	}
	
	public void remove(T data){
		map.remove(Thread.currentThread());
	}
}


/**
*Thread通常用在一个类的成员上,多个线程访问它时,每个线程都有自己的副本,互不干扰
*/
class User{
	private ThreadLocal<String> username = new ThreadLocal<String>();
}