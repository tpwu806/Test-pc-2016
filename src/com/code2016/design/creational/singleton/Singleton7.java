package com.code2016.design.creational.singleton;

/**
 * @Description: 双重校验锁
 * @author wutp 2016年9月24日
 * @version 1.0
 */
public class Singleton7 {
	private volatile static Singleton7 singleton;   
    private Singleton7 (){}  

	public static final Singleton7 getInstance() {
		if (singleton == null) {
			synchronized (Singleton7.class) {
				if (singleton == null) {
					singleton = new Singleton7();
				}
			}
		}
		return singleton;
	} 	
}
