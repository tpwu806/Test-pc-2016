package com.code2016.datadtructures.part1;

public class TestMemoryCell {

	public static void main(String[] args) {
		
		MemoryCell m=new MemoryCell();
		m.write("37");
		String val=(String) m.read();
		System.out.println("Contents ares: " + val);

	}

}
