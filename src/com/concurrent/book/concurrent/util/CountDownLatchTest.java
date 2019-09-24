package com.concurrent.book.concurrent.util;

import java.util.concurrent.CountDownLatch;
/**
 * @Description: 等待多线程等待 CountDownLatch
 * @author wutp 2017年1月4日
 * @version 1.0
 */
public class CountDownLatchTest {
	static CountDownLatch c = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
				c.countDown();
				System.out.println(2);
				c.countDown();
			}
		}).start();
		c.await();
		System.out.println("3");
	}
}
