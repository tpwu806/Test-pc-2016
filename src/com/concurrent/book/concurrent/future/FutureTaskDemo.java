package com.concurrent.book.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description: 
 * @author wutp 2017年1月4日
 * @version 1.0
 */
public class FutureTaskDemo {
	
	private final ConcurrentMap<Object, Future<String>> taskCache 
			= new ConcurrentHashMap<Object, Future<String>>();

	private String executionTask(final String taskName) throws ExecutionException, 
			InterruptedException {
		
		while (true) {
			Future<String> future = taskCache.get(taskName); // 1.1,2.1
			if (future == null) {
				Callable<String> task = new Callable<String>() {
					public String call() throws InterruptedException {
						return "返回的值："+taskName;
					}
				};
				FutureTask<String> futureTask = new FutureTask<String>(task);
				future = taskCache.putIfAbsent(taskName, futureTask); // 1.3
				if (future == null) {
					future = futureTask;
					futureTask.run(); // 1.4执行任务
				}
			}
			try {
				return future.get(); // 1.5,
			} catch (CancellationException e) {
				taskCache.remove(taskName, future);
			}
		}
	}
	
	public static void main(String[] args){
		FutureTaskDemo task = new FutureTaskDemo();
		String aa = "";
		try {
			 aa = task.executionTask("aa");
		} catch (Exception e) {
			e.printStackTrace();		
		}
		System.out.println(aa);
	}
}
