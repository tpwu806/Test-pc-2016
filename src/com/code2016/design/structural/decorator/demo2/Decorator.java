package com.code2016.design.structural.decorator.demo2;

public class Decorator implements Sourceable {

	private Sourceable source;  
    
    public Decorator(Sourceable source){  
        super();  
        this.source = source;  
    }  
    @Override  
    public void method() {  
        System.out.println("before decorator!");  
        source.method();  
        System.out.println("after decorator!");  
    } 

}
