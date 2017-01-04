package com.code2017.book.concurrent.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: 同步屏障
 * @author wutp 2017年1月4日
 * @version 1.0
 */
public class CyclicBarrierTest3 {
	static CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
				}
			}
		});
		thread.start();
		thread.interrupt();
		try {
			c.await();
		} catch (Exception e) {
			System.out.println(c.isBroken());
		}
	}
}
