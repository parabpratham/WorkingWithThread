package com.org.common.thread;

import java.util.Calendar;

public class WorkerThread extends Thread implements Worker {

	private String command;

	public WorkerThread(String s) {
		command = s;
	}

	public WorkerThread() {
	}

	@Override
	public void run() {
		System.out
				.println(Thread.currentThread().getName() + " " + Calendar.getInstance().getTimeInMillis() + " Start");
		processCommand();
		System.out.println(Thread.currentThread().getName() + " " + Calendar.getInstance().getTimeInMillis() + " End");
	}

	public void processCommand() {
		System.out.println(command);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void processCommand(String s) {
		System.out.println(s);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

}
