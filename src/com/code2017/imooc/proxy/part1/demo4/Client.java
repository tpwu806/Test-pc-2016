package com.code2017.imooc.proxy.part1.demo4;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CglibProxy proxy = new CglibProxy();
		Train t = (Train)proxy.getProxy(Train.class);
		t.move();
	}

}
