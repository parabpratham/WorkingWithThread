package com.org.common.thread;

public interface Worker extends Runnable {

	public void processCommand(String s);
	
	public void processCommand();


}
