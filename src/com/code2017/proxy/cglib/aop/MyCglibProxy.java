package com.code2017.proxy.cglib.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyCglibProxy implements MethodInterceptor {
	//private Logger log = Logger.getLogger(MyCglibProxy.class);
	public Enhancer enhancer = new Enhancer();
	private String name;

	public MyCglibProxy(String name) {
		this.name = name;
	}

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		//log.info("调用的方法是：" + method.getName());
		// 用户进行判断
		if (!"boss".equals(name)) {
			System.out.println("你没有权限！");
			return null;
		}
		Object result = methodProxy.invokeSuper(object, args);

		return result;
	}

}
