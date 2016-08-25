package day.com.day04.model.strategy;

import java.util.Arrays;

public class StrategyB implements Strategy{

	@Override
	public double computerAverage(double[] a) {
		// TODO Auto-generated method stub
		if(a.length<=2){
			return 0;
		}else{
			double score=0,sum=0;
			Arrays.sort(a);
			for(int i=1;i<a.length-1;i++){
				sum=sum+a[i];
			}
			score=sum/a.length;
			return score;}
	}

}
