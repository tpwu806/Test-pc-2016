package com.code2016.design.structural.bridge;

public abstract class Bridge {
	private Sourceable source;  
	  
    public void method(){  
        source.method();  
    }  
      
    public Sourceable getSource() {  
        return source;  
    }  
  
    public void setSource(Sourceable source) {  
        this.source = source;  
    }  
}
