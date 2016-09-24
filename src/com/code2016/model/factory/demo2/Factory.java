package com.code2016.model.factory.demo2;

public class Factory {

	public static void main(String[] args){
		demo1();		
	}
	
	public static void demo1(){
		Product a = Factory.getProduct(0);
		a.show();
		Product b = Factory.getProduct(1);
		b.show();
	}
	
	public static void demo2(){
		Product a = null;
		Product b = null;
		try {
			a = Factory.getProduct("com.code2016.model.factory.demo2.ProductA");
			a.show();			
			b = Factory.getProduct("com.code2016.model.factory.demo2.ProductB");
			b.show();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Product getProduct(int product_index) {
		if (product_index == 0)
			return new ProductA();
		if (1 == product_index)
			return new ProductB();
		return null;
	}
	
	public static Product getProduct(String className)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (Product) Class.forName(className).newInstance();

	}

}
