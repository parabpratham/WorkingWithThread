package com.org.execute;

import com.org.log.com.ComApp;
import com.org.log.com.journaldev.ComJournalDevApp;
import com.org.log.net.NetApp;
import com.org.log.net.journaldev.NetJournalDevApp;

public class LogMain {

	public static void main(String[] args) {
		new ComApp();
		new ComJournalDevApp();
		new NetApp();
		new NetJournalDevApp();
	}

}
