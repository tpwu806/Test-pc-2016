package com.code2016.design.structural.decorator;

public abstract class Decorator extends Bird{
	Bird bird;
	public Decorator(){
		
	}
	public Decorator(Bird brid){
		this.bird=brid;
	}
	public abstract int eleFly();

}
