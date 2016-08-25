package day.com.day04.model.decorator;

public class SparrowDecorator extends Decorator{

	public final int DISTANCE=50;
	SparrowDecorator(Bird bird){
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
