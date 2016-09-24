package com.code2016.model.singleton;

/**
 * @Description:饿汉 
 * @author wutp 2016年9月24日
 * @version 1.0
 */
public class Singleton3 {
	private static Singleton3 instance = new Singleton3();  
    private Singleton3 (){}  
    public static Singleton3 getInstance() {  
    	return instance;  
    }  
}
