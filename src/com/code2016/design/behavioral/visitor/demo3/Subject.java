package com.code2016.design.behavioral.visitor.demo3;

public interface Subject {
	public void accept(Visitor visitor);  
    public String getSubject(); 
}
