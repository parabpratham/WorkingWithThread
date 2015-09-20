package com.org.log.com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ComApp {
	Logger logger;

	public ComApp() {
		logger = LogManager.getLogger(ComApp.class);
	}

	public void error(String msg) {
		logger.error(msg);
	}
}
