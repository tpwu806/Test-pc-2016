package com.base.design.creational.factory.demo1;

public class BlackPenCore extends PenCore{

	BlackPenCore(){
		color="黑色";
	}
	@Override
	public void writeWord(String s) {
		// TODO Auto-generated method stub
		System.out.println("写出"+color+"的字"+s);
	}

}