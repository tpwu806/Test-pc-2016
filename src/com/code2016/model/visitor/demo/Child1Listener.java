package com.code2016.model.visitor.demo;

public class Child1Listener implements ChildListener {

	public void cry(ChildStatus event) {
		System.out.println("========"+event.getSource().getClass().getName()
				+"==="+event.getStatus()+"==============");
	}

}
