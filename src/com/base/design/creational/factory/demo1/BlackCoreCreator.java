package com.base.design.creational.factory.demo1;

public class BlackCoreCreator extends PenCoreCreator{

	@Override
	public PenCore getPenCore() {
		// TODO Auto-generated method stub
		return new BlackPenCore();
	}

}
