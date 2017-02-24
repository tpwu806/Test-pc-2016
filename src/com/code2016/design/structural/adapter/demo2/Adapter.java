package com.code2016.design.structural.adapter.demo2;

public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		 System.out.println("this is the targetable method!");  
	}

}
