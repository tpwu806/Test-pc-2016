package com.code2015.data;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> lst1=new ArrayList<String>();
		List<String> lst2=new ArrayList<String>();
		lst1.add("北京");
		lst1.add("上海");
		lst2.add("南京");
		lst2.add("重庆");
		lst1.addAll(lst2);
		for(int i=0;i<lst1.size();i++){
			System.out.println(lst1.get(i));
		}
	}
}
