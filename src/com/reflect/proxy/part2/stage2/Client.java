package com.reflect.proxy.part2.stage2;

import com.reflect.proxy.part1.demo1.Car;
import com.reflect.proxy.part1.demo1.Moveable;

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
