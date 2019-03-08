package com.code2016.imooc.reflect;

/**
 * @Description: 根据有参的构造函数生成实例
 * @author wutp 2017年9月6日
 * @version 1.0
 */
public class ConstructorDemo {

	public static void main(String[] args) throws Exception{
//		//根据类名获取Class对象    
//		  Class c=Class.forName("java.lang.Integer");      
//		//参数类型数组    
//		  Class[] parameterTypes={String.class};     
//		//根据参数类型获取相应的构造函数    
//		  java.lang.reflect.Constructor constructor=c.getConstructor(parameterTypes);    
//		//参数数组    
//		  Object[] parameters={"1"};    
//		//根据获取的构造函数和参数，创建实例    
//		  Object o=constructor.newInstance(parameters); 
		B b = new B();
		Class c = b.getClass();
		Class[] parameterTypes={String.class,String.class};
		java.lang.reflect.Constructor constructor=c.getConstructor(parameterTypes);
		Object[] parameters={"1","2"};  
		Object o=constructor.newInstance(parameters);
		String res = ((B)o).getStr();
		System.out.println(res);
		
	}

}

class B {
	public B(){
		
	}
	String a;
	String b;
	public B(String a,String b){
		this.a = a;
		this.b = b;
	}
	public void print() {
		System.out.println("helloworld");
	}

	public void print(int a, int b) {
		System.out.println(a + b);
	}

	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + "," + b.toLowerCase());
	}
	
	public String getStr() {
		return a+"helloworld"+b;
	}
}
