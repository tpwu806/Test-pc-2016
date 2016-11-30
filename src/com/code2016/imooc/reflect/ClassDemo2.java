package com.code2016.imooc.reflect;

public class ClassDemo2 {
	public static void main(String[] args) {
		
		Class<Integer> c1 = int.class;//int 的类类型
		Class<String> c2 = String.class;//String类的类类型   String类字节码（自己发明的)
		Class<Double> c3 = double.class;
		Class<Double> c4 = Double.class;
		Class<Void> c5 = void.class;
		
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());//不包含包名的类的名称
		System.out.println(c5.getName());
	}

}
