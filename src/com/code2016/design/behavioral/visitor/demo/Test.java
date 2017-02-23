package com.code2016.design.behavioral.visitor.demo;

public class Test {

	/**
	 *@Description:
	 *@author wutp 2016-11-28
	 *@param args void
	 */
	public static void main(String[] args) {
		Child c = new Child() ;
		c.addListener(new Child1Listener());
		c.doOperation();

	}

}
