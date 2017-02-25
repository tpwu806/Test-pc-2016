package com.code2017.imooc.proxy.part1.demo4;

public class Client {

	/**
	 * @Description:Cglib代理
	 * @auther: wutp 2017年2月25日
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {

		CglibProxy proxy = new CglibProxy();
		Train t = (Train)proxy.getProxy(Train.class);
		t.move();
	}

}
