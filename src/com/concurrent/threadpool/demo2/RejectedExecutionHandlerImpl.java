package com.concurrent.threadpool.demo2;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable paramRunnable,
			ThreadPoolExecutor paramThreadPoolExecutor) {
		System.out.println(paramRunnable.toString() + " is rejected");

	}

}
