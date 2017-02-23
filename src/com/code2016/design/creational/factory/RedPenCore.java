package com.code2016.design.creational.factory;

public class RedPenCore extends PenCore{

	RedPenCore(){
		color="红色";
	}
	@Override
	public void writeWord(String s) {
		// TODO Auto-generated method stub
		System.out.println("写出"+color+"的字"+s);
	}

}
