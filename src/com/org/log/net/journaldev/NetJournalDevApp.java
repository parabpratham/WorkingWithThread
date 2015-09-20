package com.org.log.net.journaldev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NetJournalDevApp {

	public NetJournalDevApp() {
		Logger logger = LogManager.getLogger(NetJournalDevApp.class);
		logger.error("NET :: JournalDev :: LEVEL :: NetJournalDevApp ERROR Message ::");
	}

}
