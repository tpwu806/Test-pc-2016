package com.code2017.imooc.proxy.part2.stage1.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.code2017.imooc.proxy.part2.stage1.proxy.Car;
import com.code2017.imooc.proxy.part2.stage1.proxy.Moveable;

public class Test {

	/**
	 * JDK��̬���������
	 */
	public static void main(String[] args) {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Class<?> cls = car.getClass();
		/**
		 * loader  �������
		 * interfaces  ʵ�ֽӿ�
		 * h InvocationHandler
		 */
		Moveable m = (Moveable)Proxy.newProxyInstance(cls.getClassLoader(),
												cls.getInterfaces(), h);
		m.move();
	}

}
