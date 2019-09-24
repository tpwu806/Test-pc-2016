package com.base.design.structural.decorator.demo1;

public abstract class Decorator extends Bird{
	Bird bird;
	public Decorator(){
		
	}
	public Decorator(Bird brid){
		this.bird=brid;
	}
	public abstract int eleFly();

}
