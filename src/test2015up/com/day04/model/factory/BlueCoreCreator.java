package test2015up.com.day04.model.factory;

public class BlueCoreCreator extends PenCoreCreator{

	@Override
	public PenCore getPenCore() {
		// TODO Auto-generated method stub
		return new BluePenCore();
	}

}
