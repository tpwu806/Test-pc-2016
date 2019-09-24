package com.base.collections;
import java.util.HashMap;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("", "jpg");
		hm.put("flash", "flash");
		System.out.println(hm.get(""));
		System.out.println(hm.get("flash"));
	}

}
