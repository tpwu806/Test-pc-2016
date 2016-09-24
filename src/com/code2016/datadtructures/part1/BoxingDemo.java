package com.code2016.datadtructures.part1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import com.code2016.datadtructures.part1.dto.Shape;

public class BoxingDemo {

	public static void main(String[] args) {
		/*GenerricMemoryCell<Integer> m=new GenerricMemoryCell<>();
		m.write(37);
		int val = (int) m.read();
		System.out.println("Contents are: " + val);*/
		
	
		/*Shape[] ss = {new Shape<>(),new Shape<>()};
		double d=totalArea(ss);
		System.out.println("Contents are: " + d);*/
		
		Collection<Shape> cs= new ArrayList<Shape>();
		cs.add(new Shape<Object>());
		cs.add(new Shape<Object>());
		double d=totalArea(cs);
		System.out.println("Contents are: " + d);
		
		Hashtable h=new Hashtable();
	}
	
	public static double totalArea(Shape[] arr){
		double total = 0;
		for(Shape s:arr){
			if(s!=null){
				total += s.area();
			}
		}
		return total;
		

	}
	public static double totalArea(Collection<Shape> arr){
		double total = 0;
		for(Shape s:arr){
			if(s!=null){
				total += s.area();
			}
		}
		return total;
		
	}

}
