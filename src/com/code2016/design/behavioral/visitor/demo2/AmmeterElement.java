package com.code2016.design.behavioral.visitor.demo2;

public abstract class AmmeterElement {
	public abstract void accept(Visitor v);
	public abstract double showElectricAmount();
	public abstract void setElectricAmount(double n);

}
