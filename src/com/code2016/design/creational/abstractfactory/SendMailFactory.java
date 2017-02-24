package com.code2016.design.creational.abstractfactory;

public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

}
