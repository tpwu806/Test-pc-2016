package com.code2016.design.behavioral.observer;

public class MySubject extends AbstractSubject {

	@Override
	public void operation() {
		System.out.println("update self!");  
        notifyObservers(); 
	}

}
