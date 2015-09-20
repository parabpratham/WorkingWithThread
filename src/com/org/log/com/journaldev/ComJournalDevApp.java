package com.org.log.com.journaldev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ComJournalDevApp {

	public ComJournalDevApp() {
		Logger logger = LogManager.getLogger(ComJournalDevApp.class);
		logger.trace("COM :: JournalDev :: LEVEL :: ComJournalDevApp TRACE Message ::");
	}

}
