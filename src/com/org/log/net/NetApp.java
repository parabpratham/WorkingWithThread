package com.org.log.net;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NetApp {

	public NetApp() {
		Logger logger = LogManager.getLogger(NetApp.class);
		logger.error("NET :: LEVEL :: NetApp ERROR Message ::");
	}
}
