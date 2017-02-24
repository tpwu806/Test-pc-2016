package com.code2016.design.behavioral.mediator;

public class User1 extends User {

	public User1(Mediator mediator){  
        super(mediator);  
    }  
      
    @Override  
    public void work() {  
        System.out.println("user1 exe!");  
    }  

}
