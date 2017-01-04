package com.code2016.book.datadtructures.part1;

public class MemoryCell {
	
	private Object storedVaue;
	
	public Object read(){		
		return storedVaue;		
	} 
	
	public void write(Object x){
		this.storedVaue=x;
	}	
	
}
