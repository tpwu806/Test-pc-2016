package com.code2017.imooc.proxy.part1.demo3;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
		//ʵ�ֿ���
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("����ʻ��....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
