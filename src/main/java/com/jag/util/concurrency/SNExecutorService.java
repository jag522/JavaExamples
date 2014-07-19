package com.jag.util.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/**
 * Global Thread Pool Service
 * 
 * @author jag 88213565
 * 
 */
public class SNExecutorService {

	private static final int corePoolSize = 24;
	private static final int maximumPoolSize = 50;
	private static final int queueSize = 500;
	private static final long keepLiveTime = 5L;

	private static ExecutorService INSTANCE = new ThreadPoolExecutor(
			corePoolSize, maximumPoolSize, keepLiveTime, TimeUnit.SECONDS,
			new ArrayBlockingQueue<Runnable>(queueSize), new CallerRunsPolicy());

	public static ExecutorService getInstance() {
		return INSTANCE;
	}

}
