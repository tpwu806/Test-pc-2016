package com.code2016.model.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		Object obj1,obj2 ;
		  obj1=Singleton3.getInstance() ;
		  obj2=Singleton3.getInstance() ;
		  System.out.println("(obj1==obk2)="+(obj1==obj2));  //结果为True证明实例唯一
	}

}
