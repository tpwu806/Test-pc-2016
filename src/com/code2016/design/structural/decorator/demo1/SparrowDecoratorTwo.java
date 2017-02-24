package com.code2016.design.structural.decorator.demo1;

public class SparrowDecoratorTwo extends Decorator{

	public final int DISTANCE=20;
	SparrowDecoratorTwo(Bird bird){
		super(bird);
	}
	@Override
	public int eleFly() {
		// TODO Auto-generated method stub		
		return DISTANCE;
	}

	@Override
	public int fly() {
		// TODO Auto-generated method stub
		int distance=0;
		distance=bird.fly()+eleFly();
		return distance;
	}

}
