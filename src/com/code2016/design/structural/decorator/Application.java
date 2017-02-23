package com.code2016.design.structural.decorator;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bird bird=new Sparrow();
		System.out.println("没安装电子翅膀的小鸟"+bird.fly());
		bird = new SparrowDecorator(bird);
		System.out.println("安装一个电子翅膀的小鸟"+bird.fly());
		bird = new SparrowDecorator(bird);
		System.out.println("安装一个电子翅膀的小鸟"+bird.fly());
		bird = new SparrowDecoratorTwo(bird);
		System.out.println("安装两个电子翅膀的小鸟"+bird.fly());
		bird = new SparrowDecoratorTwo(bird);
		System.out.println("安装三个电子翅膀的小鸟"+bird.fly());
		

	}

}
