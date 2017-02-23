package com.code2016.design.behavioral.visitor;

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
