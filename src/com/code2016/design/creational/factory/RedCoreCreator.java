package com.code2016.design.creational.factory;

public  class RedCoreCreator extends PenCoreCreator{

	@Override
	public PenCore getPenCore() {
		// TODO Auto-generated method stub		
			return new RedPenCore();

	}

}
