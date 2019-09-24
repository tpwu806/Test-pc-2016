package com.base.design.behavioral.interpreter;

/**
 * @Description: 解释器模式
 * 一般主要应用在OOP开发中的编译器的开发中，所以适用面比较窄。
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class Test {

	public static void main(String[] args) {
		int result = new Minus().interpret(new Context(new Plus()  
        	.interpret(new Context(9, 2)), 8));  
		System.out.println(result); 
	}

}
