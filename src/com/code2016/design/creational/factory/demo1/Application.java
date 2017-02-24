package com.code2016.design.creational.factory.demo1;

/**
 * @Description: java教材例子
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class Application {

	public static void main(String[] args) {
		PenCore penCore;
		PenCoreCreator creator;
		
		BallPen ballPen = new BallPen();		
		creator = new RedCoreCreator();
		penCore = creator.getPenCore();
		ballPen.usePenCore(penCore);
		ballPen.write("你好，很高兴认识你");
		
		ballPen = new BallPen();
		creator = new BlueCoreCreator();
		penCore = creator.getPenCore();
		ballPen.usePenCore(penCore);
		ballPen.write("nice to meet you");
		
		ballPen = new BallPen();
		creator = new BlackCoreCreator();
		penCore = creator.getPenCore();
		ballPen.usePenCore(penCore);
		ballPen.write("how are you");

	}

}
