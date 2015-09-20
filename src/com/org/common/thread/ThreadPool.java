package com.org.common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		ExecutorService executor = Executors.newFixedThreadPool(5);// creating a
																	// pool of 5
																	// threads
		for (int i = 0; i < 10; i++) {

			Thread worker = new WorkerThread("Running method" + i);
			r.addShutdownHook(worker);

			executor.execute(worker);// calling execute method of
										// ExecutorService
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");
	}

}
