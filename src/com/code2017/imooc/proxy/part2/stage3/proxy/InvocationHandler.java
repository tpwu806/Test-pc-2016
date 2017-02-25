package com.code2017.imooc.proxy.part2.stage3.proxy;

import java.lang.reflect.Method;

public interface InvocationHandler {

	public void invoke(Object o,Method m);
}
