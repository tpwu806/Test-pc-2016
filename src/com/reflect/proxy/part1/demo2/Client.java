package com.reflect.proxy.part1.demo2;

import com.reflect.proxy.part1.demo1.Car;

public class Client {

	/**
	 * @Description:测试类
	 * 聚合方式代理可以更灵活的实现各种功能
	 * @auther: wutp 2017年2月25日
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		Car car = new Car();
		CarLogProxy clp = new CarLogProxy(car);
		CarTimeProxy ctp = new CarTimeProxy(clp);
		ctp.move();
	}

}
