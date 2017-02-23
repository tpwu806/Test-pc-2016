package com.code2016.design.creational.factory;

public class BlackCoreCreator extends PenCoreCreator{

	@Override
	public PenCore getPenCore() {
		// TODO Auto-generated method stub
		return new BlackPenCore();
	}

}
