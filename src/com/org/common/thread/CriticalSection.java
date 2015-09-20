package com.org.common.thread;

import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.Logger;

import com.org.log.com.AppLogger;
import com.org.log.com.ComApp;

public class CriticalSection {

	public final static Lock method1 = new ReentrantLock();
	public final static Lock method2 = new ReentrantLock();
	public static int m1 = 0, m2 = 0;
	static Logger rootLogger = AppLogger.getLogger();
	static ComApp erroLogger = AppLogger.getComAppLogger();

	public static boolean tryLockMethod1() {
		return method1.tryLock();
	}

	public static boolean tryLockMethod2() {
		return method2.tryLock();
	}

	public static boolean unlockMethod1() {
		try {
			method1.unlock();
			rootLogger.debug(Thread.currentThread().getName() + " Method1 unlocked "
					+ Calendar.getInstance().getTimeInMillis() + " " + 0);
		} catch (Exception e) {
			erroLogger.error(Thread.currentThread().getName() + " Method1 unloerro "
					+ Calendar.getInstance().getTimeInMillis() + " " + e.getMessage());
			return false;
		}

		return true;
	}

	public static boolean unlockMethod2() {

		try {
			method2.unlock();
			rootLogger.debug(Thread.currentThread().getName() + " Method2 unlocked "
					+ Calendar.getInstance().getTimeInMillis() + " " + 0);
		} catch (Exception e) {
			erroLogger.error(Thread.currentThread().getName() + " Method2 unloerro "
					+ Calendar.getInstance().getTimeInMillis() + " " + e.getMessage());
			return false;
		}

		return true;
	}

	public static void cs1(String threadName, String method) {
		try {
			m1++;
			rootLogger.debug(
					threadName + " " + method + " Executed " + Calendar.getInstance().getTimeInMillis() + " " + m1);
			Thread.sleep(50);
			m1 = 0;
		} catch (Exception e) {
			erroLogger.error(e.getMessage());
		}
	}

	public static void cs2(String threadName, String method) {
		try {
			m2++;
			rootLogger.debug(
					threadName + " " + method + " Executed " + Calendar.getInstance().getTimeInMillis() + " " + m2);
			Thread.sleep(50);
			m2 = 0;
		} catch (Exception e) {
			erroLogger.error(e.getMessage());
		}
	}
}