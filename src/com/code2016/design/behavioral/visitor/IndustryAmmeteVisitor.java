package com.code2016.design.behavioral.visitor;

public class IndustryAmmeteVisitor implements Visitor{

	@Override
	public double visit(AmmeterElement ammeter) {
		// TODO Auto-generated method stub
		double charge=0;
		double unitOne=1.52,unitTwo=2.78;
		int basic =15000;
		double n=ammeter.showElectricAmount();
		if(n<=basic){
			charge= n * unitOne;
		}else{
			charge=basic*unitOne+(n-basic)*unitTwo;
		}
		return charge;
	}

}