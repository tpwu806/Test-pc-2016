package com.code2017.imooc.proxy.part1.demo2;

import com.code2017.imooc.proxy.part1.demo1.Moveable;

public class CarLogProxy implements Moveable {

	public CarLogProxy(Moveable m) {
		super();
		this.m = m;
	}

	private Moveable m;
	
	@Override
	public void move() {
		System.out.println("日志开始....");
		m.move();
		System.out.println("日志结束....");
	}

}
