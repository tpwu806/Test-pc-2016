package com.code2015.task.thread;

import java.util.ArrayList;
import java.util.List;

class Data {
	public int value = 0;
}

class Work {
	public void process(Data data, List<Integer> list) {
		for (int n : list) {
			data.value += n;
		}
	}
}

public class MyThread extends Thread {
	private Work work;

	public MyThread(Work work) {
		this.work = work;
	}

	public void run() {
		java.util.Random random = new java.util.Random();
		Data data = new Data();
		List<Integer> list = new ArrayList<Integer>();
		int n1 = random.nextInt(1000);
		int n2 = random.nextInt(2000);
		int n3 = random.nextInt(3000);
		list.add(n1);
		list.add(n2);
		list.add(n3);
		work.process(data, list); // 使用回调函数
		System.out.println(String.valueOf(n1) + "+" + String.valueOf(n2) + "+" + String.valueOf(n3) + "=" + data.value);
	}

	public static void main(String[] args) {
		Thread thread = new MyThread(new Work());
		thread.start();
	}
}