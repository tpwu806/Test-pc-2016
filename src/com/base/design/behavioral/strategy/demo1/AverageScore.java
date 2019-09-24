package com.base.design.behavioral.strategy.demo1;

public class AverageScore {

	Strategy strategy;
	public void setStrategy(Strategy strategy){
		this.strategy= strategy;
		
	}
	public double getAverage (double []a){
		if(strategy!= null){
			return strategy.computerAverage(a);
		}else{
			return -1;
		}
	}
}
