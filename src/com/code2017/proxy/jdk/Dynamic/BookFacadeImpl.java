package com.code2017.proxy.jdk.Dynamic;

public class BookFacadeImpl implements BookFacade {

	@Override
	public void addBook() {
		System.out.println("增加图书方法。。。");  
	}

	@Override
	public int gethe(int a, int b) {
		return a+b;
	}

}
