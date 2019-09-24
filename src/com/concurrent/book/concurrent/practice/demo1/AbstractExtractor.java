package com.concurrent.book.concurrent.practice.demo1;

import java.util.List;

public class AbstractExtractor {

	protected void addArticleOrComment(Article article) {
		// TODO Auto-generated method stub	
		
	}
	
	protected void cleanEmail() {
		// TODO Auto-generated method stub
		
	}
	
	protected EmailService getEmailService() {
		return new EmailService();
	}
	
	protected List<ExchangeEmailShallowDTO> queryAllEmails(){
		return null;
	}

}
