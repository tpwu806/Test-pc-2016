package com.reflect.proxy.part2.stage1;

import com.reflect.proxy.part1.demo1.Moveable;

public class Client {

	/**
	 * 测试类
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class);
		m.move();
	}

}
