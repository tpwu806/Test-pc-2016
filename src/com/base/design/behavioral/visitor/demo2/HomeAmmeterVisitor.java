package com.base.design.behavioral.visitor.demo2;

public class HomeAmmeterVisitor implements Visitor{

	@Override
	public double visit(AmmeterElement ammeter) {
		// TODO Auto-generated method stub
		double charge=0;
		double unitOne=0.6,unitTwo=1.05;
		int basic =6000;
		double n=ammeter.showElectricAmount();
		if(n<=basic){
			charge= n * unitOne;
		}else{
			charge=basic*unitOne+(n-basic)*unitTwo;
		}
		return charge;
	}

}
