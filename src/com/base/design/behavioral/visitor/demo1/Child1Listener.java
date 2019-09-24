package com.base.design.behavioral.visitor.demo1;

public class Child1Listener implements ChildListener {

	public void cry(ChildStatus event) {
		System.out.println("========"+event.getSource().getClass().getName()
				+"==="+event.getStatus()+"==============");
	}

}
