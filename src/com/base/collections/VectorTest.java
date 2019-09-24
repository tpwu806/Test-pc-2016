package com.base.collections;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	static Vector<String> v1 = new Vector<String>();
	static Vector<String> v2 = new Vector<String>();
	static Vector<String> v3 = new Vector<String>();
	public static void main(String[] args) {
		v2.add("me");
		v2.add("online1");
		v2.add("online2");
		v3.add("out1");
		v3.add("out2");
		
		v1.addAll(v2);
		v1.addAll(v3);
		
		for(Object n : v1){
			System.out.println(n);
		}
		
		/**
		 * 枚举遍历
		 */		
		Enumeration<String> e = v1.elements();		
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}

	}

}
