package com.code2015.genericity.demo2;

import java.util.ArrayList;
import java.util.List;

public class GenDemo {

	public static void main(String[] args) {
        // 定义泛型类Gen的一个Integer版本
        Gen<Integer> intOb = new Gen<Integer>();
        List ll=new ArrayList();
        List l = intOb.getObs(ll);
        System.out.println("value= " +l);
        System.out.println("----------------------------------");
        
    }
}
