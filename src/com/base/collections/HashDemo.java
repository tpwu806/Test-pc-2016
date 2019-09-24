package com.base.collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashDemo {

	public static void main(String[] args) {
		HashSet s = new HashSet();
		Iterator it = s.iterator();
		if(it.hasNext())
			it.next();

	}

}
