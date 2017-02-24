package com.code2016.design.behavioral.visitor.demo2;

/**
 * @Description: 访问者模式 课本
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Visitor visitor =new HomeAmmeterVisitor();
		Ammeter ammeter =new Ammeter();
		ammeter.setElectricAmount(5678);
		ammeter.accept(visitor);
		visitor = new IndustryAmmeteVisitor();
		ammeter.setElectricAmount(5678);
		ammeter.accept(visitor);
 
	}

}
