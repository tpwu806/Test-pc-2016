package com.base.design.creational.singleton;

/**
 * @Description:饿汉 变种
 * 表面上看起来差别挺大，其实更第三种方式差不多，都是在类初始化即实例化instance。
 * @author wutp 2016年9月24日
 * @version 1.0
 */
public class Singleton4 {
	private static Singleton4 instance = null; 
	static {
		instance = new Singleton4(); 
	}
    private Singleton4 (){}  
    public static Singleton4 getInstance() {  
    	return instance;  
    }  
}
