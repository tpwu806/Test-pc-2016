package com.code2017.proxy.jdk.Dynamic;

public class TestProxy {
	public static void main(String[] args) {  
        BookFacadeProxy proxy = new BookFacadeProxy();  
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());  
        bookProxy.addBook();  
        int n = (int)bookProxy.gethe(5, 4); 
        System.out.println(n);
    }  
}
