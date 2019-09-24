package com.base.design.behavioral.visitor.demo1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Child {
	
	private Collection listener;//注册事件后，监听者对象就保存在这个容器当中
	//添加事件
	public void addListener(ChildListener  xx) {
		if(listener == null) {
			listener  = new HashSet() ;
		}
		listener.add(xx);	
	}
	 //移除事件
	public void moveListener(ChildListener xx) {
		if(listener == null){
			return ;
		}
		listener.remove(xx);
	}
	//触发事件
	public void doOperation() {
		if(listener == null) 
			return;
		ChildStatus ev = new ChildStatus(this, "孩子被打了屁股，大哭起来了");
		notifyAllListen(ev);
	}
	//通知所有事件
	public void notifyAllListen(ChildStatus ev) {
		Iterator it = listener.iterator();
		while(it.hasNext()) {
			ChildListener lis = (ChildListener) it.next();
			lis.cry(ev);
		}
	}
}
