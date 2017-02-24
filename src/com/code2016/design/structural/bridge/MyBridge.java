package com.code2016.design.structural.bridge;

public class MyBridge extends Bridge {
	public void method(){  
        getSource().method();  
    }
}
