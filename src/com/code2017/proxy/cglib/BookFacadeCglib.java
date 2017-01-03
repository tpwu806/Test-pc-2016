package com.code2017.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/** 
 * 使用cglib动态代理 
 *  
 * @author student 
 *  
 */  
public class BookFacadeCglib implements MethodInterceptor {
	/**
	 * 创建代理对象
	 * 
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) 
			throws Throwable {
		Object result = null;
		System.out.println("事物开始");  
		result = proxy.invokeSuper(obj, args);  
        System.out.println("事物结束");  
		return result;
	}

}
