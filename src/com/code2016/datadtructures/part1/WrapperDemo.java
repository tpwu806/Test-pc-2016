package com.code2016.datadtructures.part1;

public class WrapperDemo {

	public static void main(String[] args) {
		MemoryCell m=new MemoryCell();
		
		m.write(new Integer(37));
		Integer wrapperVal =(Integer) m.read();
		int val=wrapperVal.intValue();
		System.out.println("Contents are: " + val);

	}

}
