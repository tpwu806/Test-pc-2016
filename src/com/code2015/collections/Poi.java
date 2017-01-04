package com.code2015.collections;

import java.util.ArrayList;
import java.util.List;

public class Poi {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>() ;
		for(int a=0;a<=2;a++){
			list.add(a);
		}
		for(int b=0;b<list.size();b++){
			System.out.println(list.get(b));
		}
	}
}
