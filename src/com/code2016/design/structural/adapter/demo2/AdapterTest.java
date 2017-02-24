package com.code2016.design.structural.adapter.demo2;

/**
 * @Description: 类的适配器模式
 * 有一个Source类，拥有一个方法，待适配，目标接口时Targetable，通过Adapter类，
 * 将Source的功能扩展到Targetable里
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class AdapterTest {

	public static void main(String[] args) {
		Targetable target = new Adapter();  
        target.method1();  
        target.method2();
	}

}
