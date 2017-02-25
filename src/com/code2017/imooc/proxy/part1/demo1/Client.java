package com.code2017.imooc.proxy.part1.demo1;


public class Client {

	/**
	 * @Description:测试类
	 * 使用继承方式和聚合方式代理
	 * @auther: wutp 2017年2月25日
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
//		Car car = new Car();
//		car.move();
		//使用集成方式
//		Moveable m = new Car2();
//		m.move();
		//使用聚合方式实现
		Car car = new Car();
		Moveable m = new Car3(car);
		m.move();
	}

}
