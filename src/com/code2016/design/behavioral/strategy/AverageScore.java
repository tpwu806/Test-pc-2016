package com.code2016.design.behavioral.strategy;

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
