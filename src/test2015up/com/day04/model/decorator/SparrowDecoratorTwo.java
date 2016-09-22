package test2015up.com.day04.model.decorator;

public class SparrowDecoratorTwo extends Decorator{

	public final int DISTANCE=20;
	SparrowDecoratorTwo(Bird bird){
		super(bird);
	}
	@Override
	public int eleFly() {
		// TODO Auto-generated method stub		
		return DISTANCE;
	}

	@Override
	public int fly() {
		// TODO Auto-generated method stub
		int distance=0;
		distance=bird.fly()+eleFly();
		return distance;
	}

}
