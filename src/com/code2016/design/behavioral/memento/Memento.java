package com.code2016.design.behavioral.memento;

public class Memento {
	
	private String value;  
	  
    public Memento(String value) {  
        this.value = value;  
    }  
  
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value; 
    }
}
