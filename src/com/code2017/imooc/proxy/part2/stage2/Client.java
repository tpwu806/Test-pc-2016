package com.code2017.imooc.proxy.part2.stage2;

import com.code2017.imooc.proxy.part1.demo1.Car;
import com.code2017.imooc.proxy.part1.demo1.Moveable;

public class Client {


	/**
	 * 测试类
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class,h);
		m.move();
	}

}
