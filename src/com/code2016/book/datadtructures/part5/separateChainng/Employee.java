package com.code2016.book.datadtructures.part5.separateChainng;

public class Employee {

	private String name;
	private double salary;
	private int seniority;
	
	public boolean equals(Object rhs){
		return rhs instanceof Employee && name.equals(((Employee)rhs).name);		
	}
}
