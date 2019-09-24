package com.base.design.creational.factory.demo3;

/**
 * @Description:工厂方法模式
 * 工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
 * 在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，第三种相对于第二种，
 * 不需要实例化工厂类，所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
 * @author wutp 2017年2月24日
 * @version 1.0
 */
public class FactoryTest {

	public static void main(String[] args) {
		/**
		 * 普通工厂模式
		 * 就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
		 */
		SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("sms");  
        sender.Send();
        
        /**
		 * 多个工厂方法模式
		 * 是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，
		 * 则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
		 */
        SendFactory factory2 = new SendFactory();  
        Sender sender2 = factory2.produceMail();  
        sender2.Send(); 
        
        /**
         * 静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
         */
        Sender sender3 = SendFactory.produceMail3();  
        sender3.Send();  
	}

}
