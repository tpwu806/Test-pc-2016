package com.code2016.model.visitor.demo;

import java.util.EventListener;

public interface ChildListener extends EventListener {
	public void cry(ChildStatus event);	
}
