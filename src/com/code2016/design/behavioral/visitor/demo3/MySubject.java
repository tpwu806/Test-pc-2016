package com.code2016.design.behavioral.visitor.demo3;

public class MySubject implements Subject {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		 return "love";  
	}

}
