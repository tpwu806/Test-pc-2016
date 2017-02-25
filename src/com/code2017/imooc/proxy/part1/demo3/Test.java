package com.code2017.imooc.proxy.part1.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.code2017.imooc.proxy.part1.demo1.Car;
import com.code2017.imooc.proxy.part1.demo1.Moveable;

public class Test {

	/**
	 * JDK动态代理测试类
	 */
	public static void main(String[] args) {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Class<?> cls = car.getClass();
		/**
		 * loader  类加载器
		 * interfaces  实现接口
		 * h InvocationHandler
		 * 
		 * jdk动态代理实现思路
		 * 实现功能：通过Proxy的newProxyInstance返回代理对象
		 * 1、声明一段代码（动态产生代理）
		 * 2、编译源码（JDK Compiler API），产生一个新的对象（代理对象）
		 * 3、将这个类load到内存中，产生一个新的对象（代理对象）
		 * 4、return 代理对象
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),
				cls.getInterfaces(), h);
		System.out.println("代理类名字"+m.getClass().getName());	
		m.move();
	}
}
