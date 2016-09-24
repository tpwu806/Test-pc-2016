package com.code2016.model.visitor;

public abstract class AmmeterElement {
	public abstract void accept(Visitor v);
	public abstract double showElectricAmount();
	public abstract void setElectricAmount(double n);

}
