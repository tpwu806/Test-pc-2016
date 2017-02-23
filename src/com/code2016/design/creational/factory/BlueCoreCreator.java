package com.code2016.design.creational.factory;

public class BlueCoreCreator extends PenCoreCreator{

	@Override
	public PenCore getPenCore() {
		// TODO Auto-generated method stub
		return new BluePenCore();
	}

}
