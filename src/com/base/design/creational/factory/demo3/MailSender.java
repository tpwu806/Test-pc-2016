package com.base.design.creational.factory.demo3;

public class MailSender implements Sender {

	@Override
	public void Send() {
		 System.out.println("this is mailsender!");
	}

}
