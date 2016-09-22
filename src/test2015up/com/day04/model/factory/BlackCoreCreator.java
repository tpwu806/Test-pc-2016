package test2015up.com.day04.model.factory;

public class BlackCoreCreator extends PenCoreCreator{

	@Override
	public PenCore getPenCore() {
		// TODO Auto-generated method stub
		return new BlackPenCore();
	}

}
