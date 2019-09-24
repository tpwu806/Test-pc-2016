package com.reflect.accessible;

public class Smss {
	private String destID;
	private String content;
	private String mobile;

	public Smss (){
		
	}
	
	private Smss (String content){
		this.content = content;
	}
	
	public String getDestID() {
		return destID;
	}

	public String getContent() {
		return content;
	}

	public String getMobile() {
		return mobile;
	}

	private void setContent(String content) {
		this.content = content;
	}
	
	
}
