package com.code2016.design.creational.factory.demo1;

public class BallPen {
	PenCore core;
	public void usePenCore(PenCore core){
		this.core=core;
	}
	public void write(String s){
		core.writeWord(s);
	}

}
