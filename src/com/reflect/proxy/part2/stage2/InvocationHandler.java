package com.reflect.proxy.part2.stage2;

import java.lang.reflect.Method;

public interface InvocationHandler {

	public void invoke(Object o,Method m);
}
