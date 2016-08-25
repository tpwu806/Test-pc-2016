package day.com.day04.model.factory;

public class BluePenCore extends PenCore{

	BluePenCore(){
		color="蓝色";
	}
	@Override
	public void writeWord(String s) {
		// TODO Auto-generated method stub
		System.out.println("写出"+color+"的字"+s);
	}

}