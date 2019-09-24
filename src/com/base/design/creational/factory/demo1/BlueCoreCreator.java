package com.base.design.creational.factory.demo1;

public class BlueCoreCreator extends PenCoreCreator{

	@Override
	public PenCore getPenCore() {
		// TODO Auto-generated method stub
		return new BluePenCore();
	}

}
