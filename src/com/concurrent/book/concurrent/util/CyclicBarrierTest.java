package com.concurrent.book.concurrent.util;

import java.util.concurrent.CyclicBarrier;

/**
 * @Description: 同步屏障
 * @author wutp 2017年1月4日
 * @version 1.0
 */
public class CyclicBarrierTest {
	static CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
				}
				System.out.println(1);
			}
		}).start();
		try {
			c.await();
		} catch (Exception e) {
		}
		System.out.println(2);
	}
}