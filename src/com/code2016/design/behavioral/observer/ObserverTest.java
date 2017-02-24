package com.code2016.design.behavioral.observer;

public class ObserverTest {

	public static void main(String[] args) {
		Subject sub = new MySubject();  
        sub.add(new Observer1());  
        sub.add(new Observer2());  
          
        sub.operation(); 
	}

}
