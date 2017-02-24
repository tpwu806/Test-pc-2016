package com.code2015.collections;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @Description: 遍历效率测试
 * @author wutp 2015年2月24日
 * @version 1.0
 */
public class ListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		long t1, t2;
		for (int j = 0; j < 10000000; j++) {
			list.add("aaaaaa" + j);
		}

		/**
		 * for earch
		 */
		System.out.println("List first visit method:");
		t1 = System.currentTimeMillis();
		for (String tmp : list) {
			// System.out.println(tmp);
		}
		t2 = System.currentTimeMillis();
		System.out.println("Run Time:" + (t2 - t1) + "(ms)");
		System.out.println("List second visit method:");

		/**
		 * 普通遍历
		 */
		t1 = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
			// System.out.println(list.get(i));
		}
		t2 = System.currentTimeMillis();
		System.out.println("Run Time:" + (t2 - t1) + "(ms)");

		/**
		 * 迭代遍历
		 */
		System.out.println("List Third visit method:");
		Iterator<String> iter = list.iterator();

		t1 = System.currentTimeMillis();
		while (iter.hasNext()) {
			iter.next();
			// System.out.println(iter.next());
		}
		t2 = System.currentTimeMillis();
		System.out.println("Run Time:" + (t2 - t1) + "(ms)");

		System.out.println("Finished!!!!!!!!");

	}
}
