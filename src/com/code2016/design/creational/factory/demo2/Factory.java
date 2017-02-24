package com.code2016.design.creational.factory.demo2;

/**
 * @Description: 工厂模式 慕课网
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 * 总体来说，工厂模式适合：凡是出现了大量的产品需要创建，
 * 并且具有共同的接口时，可以通过工厂方法模式进行创建。
 * 在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，
 * 第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，
 * 我们会选用第三种——静态工厂方法模式。
 * @author wutp 2017年2月23日
 * @version 1.0
 */
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
