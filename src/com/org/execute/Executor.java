package com.org.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.org.common.thread.WorkerThread;

public class Executor {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("Comand " + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated())
			;

		System.out.println("Finished All");
	}

}
