package com.code2016.design.behavioral.visitor.demo3;

public class MyVisitor implements Visitor {

	@Override
	public void visit(Subject sub) {
		 System.out.println("visit the subject："+sub.getSubject()); 
	}

}
