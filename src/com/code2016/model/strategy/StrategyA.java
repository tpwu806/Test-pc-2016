package com.code2016.model.strategy;

public class StrategyA implements Strategy{

	@Override
	public double computerAverage(double[] a) {
		// TODO Auto-generated method stub
		double score=0,sum=0;
		for(int i=0;i<a.length;i++){
			sum=sum+a[i];
		}
		score=sum/a.length;
		return score;
	}

}
