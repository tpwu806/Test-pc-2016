package day.com.day04.model.factory;

public  class RedCoreCreator extends PenCoreCreator{

	@Override
	public PenCore getPenCore() {
		// TODO Auto-generated method stub		
			return new RedPenCore();

	}

}
