package test2015up.com.day04.model.factory;

public class BallPen {
	PenCore core;
	public void usePenCore(PenCore core){
		this.core=core;
	}
	public void write(String s){
		core.writeWord(s);
	}

}
