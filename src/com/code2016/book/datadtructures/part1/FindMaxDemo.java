package com.code2016.book.datadtructures.part1;

import com.code2016.book.datadtructures.part1.dto.Circle;
import com.code2016.book.datadtructures.part1.dto.Rectangle;
import com.code2016.book.datadtructures.part1.dto.Shape;
import com.code2016.book.datadtructures.part1.dto.Square;

public class FindMaxDemo {

	public static Comparable<?> findMax(Comparable[] arr){
		int maxIndex= 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i].compareTo(arr[maxIndex])>0){
				maxIndex=i;
			}
		}
		return arr[maxIndex];
		
	}
	public static void main(String[] args) {
		
		
		Shape[] sh1 = { 
				new Circle<Object> (2.0),
				new Square<Object> (3.0),
				new Rectangle<Object> (3.0,4.0)
		};
		String[] st1 = {"Joe","Bob","Bill","Zeke"};
	String sss=new String("aa") ; 
	sss.compareTo("anotherString");
		Integer[] in1= {1,4,2};
		
		System.out.println(findMax(sh1));
		System.out.println(findMax(st1));
		System.out.println(findMax(in1));


	}

}
