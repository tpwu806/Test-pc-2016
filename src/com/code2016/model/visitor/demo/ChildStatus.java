package com.code2016.model.visitor.demo;

import java.util.EventObject;

public class ChildStatus extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;//孩子的状态
	
	public ChildStatus(Object source,String status) {
		super(source);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
