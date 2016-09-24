package com.code2015.memory;

import java.util.ArrayList;

public class Memory {

	public static void main(String[] args){
		ArrayList a = new ArrayList();
	    ArrayList b = new ArrayList();
	    a.add("a");
	    b=new ArrayList(a);
	    a.add("b");
		System.out.println(a);
		System.out.println(b);
		
		//Integer a = "";
	}
	
	
}
