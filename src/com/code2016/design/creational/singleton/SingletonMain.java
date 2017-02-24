package com.code2016.design.creational.singleton;

/**
 * @Description: 单例模式
 * 单例对象（Singleton）是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，
 * 该对象只有一个实例存在。这样的模式有几个好处：
 * 1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
 * 2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
 * 3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，
 * 系统完全乱了。（比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），所以只有使用单例模式，
 * 才能保证核心交易服务器独立控制整个流程。
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class SingletonMain {

	public static void main(String[] args) {
		Object obj1, obj2;
		obj1 = Singleton3.getInstance();
		obj2 = Singleton3.getInstance();
		System.out.println("(obj1==obk2)=" + (obj1 == obj2)); // 结果为True证明实例唯一
	}

}
