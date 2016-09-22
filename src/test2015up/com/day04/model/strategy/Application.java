package test2015up.com.day04.model.strategy;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person zhang=new Person();
		zhang.setName("张三");
		double []a={9.12,9.25,8.87,9.99,6.99,7.88};
		
		AverageScore game=new AverageScore();
		
		game.setStrategy(new StrategyA());		
		zhang.setScore(game.getAverage(a));
		System.out.println("算法A");
		System.out.printf("%s最后得分：%5.3f%n",zhang.getName(),zhang.getScore());
		
		game.setStrategy(new StrategyB());
		zhang.setScore(game.getAverage(a));
		System.out.println("算法B");
		System.out.printf("%s最后得分：%5.3f%n",zhang.getName(),zhang.getScore());	

	}

}

class Person{
	String name;
	double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
