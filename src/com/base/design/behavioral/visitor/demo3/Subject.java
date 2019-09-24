package com.base.design.behavioral.visitor.demo3;

public interface Subject {
	public void accept(Visitor visitor);  
    public String getSubject(); 
}
