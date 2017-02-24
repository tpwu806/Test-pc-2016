package com.code2016.design.creational.factory.demo3;

public class SmsSender implements Sender {

	@Override
	public void Send() {
		 System.out.println("this is SmsSender!");
	}

}
