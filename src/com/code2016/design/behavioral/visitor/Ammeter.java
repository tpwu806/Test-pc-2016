package com.code2016.design.behavioral.visitor;

public class Ammeter extends AmmeterElement{

	double electricAmount;
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		double feiyong=v.visit(this);
		System.out.println("当前电表的用户需要交电费"+ feiyong +"元");
	}

	@Override
	public double showElectricAmount() {
		// TODO Auto-generated method stub
		return electricAmount;
	}

	@Override
	public void setElectricAmount(double n) {
		// TODO Auto-generated method stub
		electricAmount=n;
	}

}
