package com.code2017.proxy.cglib.aop;

public class Client {
	public static void main(String[] args) {     
        /*BookServiceBean service = BookServiceFactory.getInstance();   
        doMethod(service); */
        
        /*BookServiceBean service = BookServiceFactory.getProxyInstance(new MyCglibProxy("boss"));  
        service.create();  
        BookServiceBean service2 = BookServiceFactory.getProxyInstance(new MyCglibProxy("john"));  
        service2.create();  */
		
		BookServiceBean service = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("jhon"));
		service.create();
		BookServiceBean service2 = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("jhon"));
		service2.query();
    }     
    public static void doMethod(BookServiceBean service){     
        service.create();  
        service.update();  
        service.query();  
        service.delete();   
    } 
    
   
}
