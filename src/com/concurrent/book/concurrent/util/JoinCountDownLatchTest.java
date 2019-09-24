package com.concurrent.book.concurrent.util;

/**
 * @Description: 等待多线程等待 join
 * @author wutp 2017年1月4日
 * @version 1.0
 */
public class JoinCountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		Thread parser1 = new Thread(new Runnable() {
			@Override
			public void run() {
			}
		});
		Thread parser2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("parser2 finish");
			}
		});
		parser1.start();
		parser2.start();
		parser1.join();
		parser2.join();
		System.out.println("all parser finish");
	}
}
