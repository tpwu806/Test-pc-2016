package com.base.design.creational.builder;

/**
 * @Description: 建造者模式
 * 建造者模式则是将各种产品集中起来进行管理，用来创建复合对象，
 * 所谓复合对象就是指某个类具有不同的属性，
 * 其实建造者模式就是前面抽象工厂模式和最后的Test结合起来得到的。
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class Test {

	public static void main(String[] args) {
		 Builder builder = new Builder();  
	     builder.produceMailSender(10); 
	}

}
