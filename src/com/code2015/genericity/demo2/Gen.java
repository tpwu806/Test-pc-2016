package com.code2015.genericity.demo2;

import java.util.ArrayList;
import java.util.List;

public class Gen<T> {
	private T ob; // 定义泛型成员变量
	int i =6;
	public Gen(T ob) {
        this.ob = ob;
    }
	
	public Gen() {
       
    }
	
	public T getOb() {
        return ob;
    }
	
	public <T>T getObs(T t) {
		
		
		List l=new ArrayList();
		l.add(6);
		l.add(5);
		
		
		
        return (T) l;
    }
}
