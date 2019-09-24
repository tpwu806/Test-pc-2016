package com.base.design.structural.bridge;

public class MyBridge extends Bridge {
	public void method(){  
        getSource().method();  
    }
}
