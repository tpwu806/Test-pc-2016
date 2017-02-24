package com.code2016.design.behavioral.iterator;

public interface Iterator {
	public Object previous();  
    
    //后移  
    public Object next();  
    public boolean hasNext();  
      
    //取得第一个元素  
    public Object first(); 
}
