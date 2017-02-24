package com.code2016.design.creational.abstractfactory;

public class MailSender implements Sender {

	@Override
	public void Send() {
		System.out.println("this is mailsender!");  
	}

}
