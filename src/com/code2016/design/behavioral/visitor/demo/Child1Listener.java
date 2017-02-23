package com.code2016.design.behavioral.visitor.demo;

public class Child1Listener implements ChildListener {

	public void cry(ChildStatus event) {
		System.out.println("========"+event.getSource().getClass().getName()
				+"==="+event.getStatus()+"==============");
	}

}
