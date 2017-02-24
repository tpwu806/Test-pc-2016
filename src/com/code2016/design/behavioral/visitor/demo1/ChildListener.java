package com.code2016.design.behavioral.visitor.demo1;

import java.util.EventListener;

public interface ChildListener extends EventListener {
	public void cry(ChildStatus event);	
}
