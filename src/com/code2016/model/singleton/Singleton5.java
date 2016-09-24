package com.code2016.model.singleton;

/**
 * @Description: 静态内部类
 * @author wutp 2016年9月24日
 * @version 1.0
 */
public class Singleton5 {
	  
    private Singleton5 (){}  
    public static final Singleton5 getInstance() {  
    	return SingletonHolder.INSTANCE;  
    }  
    
    private static class SingletonHolder {  
	    private static final Singleton5 INSTANCE = new Singleton5();  
	}
}
