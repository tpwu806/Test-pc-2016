package com.base.book.datadtructures.part1;

public class GenerricMemoryCell<T> {
	
	private T storedValue;
	
	public T read(){		
		return storedValue;		
	}

	public void write(T x){
		this.storedValue=x;
	}
}
