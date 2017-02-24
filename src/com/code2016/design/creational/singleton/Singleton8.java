package com.code2016.design.creational.singleton;

/**
 * @Description: 
 * 如果Singleton实现了java.io.Serializable接口，
 * 那么这个类的实例就可能被序列化和复原。不管怎样，如果你序列化一个单例类的对象，
 * 接下来复原多个那个对象，那你就会有多个单例类的实例。
 * @author wutp 2017年2月24日
 * @version 1.0
 */
public class Singleton8 implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Singleton8 INSTANCE = new Singleton8();

	protected Singleton8() {

	}

	private Object readResolve() {
		return INSTANCE;
	}
	
	
	/**
	 * @Description: 1、如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。
	 * 假定不是远端存取，例如一些servlet容器对每个servlet使用完全不同的类  装载器，
	 * 这样的话如果有两个servlet访问一个单例类，它们就都会有各自的实例。
	 * @auther: wutp 2017年2月24日
	 * @param classname
	 * @return
	 * @throws ClassNotFoundException
	 * @return Class
	 */
	private static Class getClass(String classname)
			throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();

		if (classLoader == null)
			classLoader = Singleton7.class.getClassLoader();

		return (classLoader.loadClass(classname));
	} 
}
