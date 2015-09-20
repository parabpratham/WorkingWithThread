package com.org.execute;

import com.org.common.thread.CriticalSection;

public class DualCriticalSection implements Runnable {

	public int id;

	public DualCriticalSection(int s) {
		id = s;
		new CriticalSection();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Runnable ds = new DualCriticalSection(i);
			new Thread(ds).start();
		}
	}

	@Override
	public String toString() {
		return super.toString() + "" + id;
	}

	public void run() {
		boolean method1Done = false, method2Done = false;
		while (!method1Done || !method2Done) {
			if (!method1Done && CriticalSection.tryLockMethod1()) {
				try {
					CriticalSection.cs1(Thread.currentThread().getName(), "Method1");
					method1Done = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					CriticalSection.unlockMethod1();
				}
			}

			if (!method2Done && CriticalSection.tryLockMethod2()) {
				try {
					CriticalSection.cs2(Thread.currentThread().getName(), "Method2");
					method2Done = true;
				}
				catch (Exception e) {
					e.printStackTrace();
				} finally {
					CriticalSection.unlockMethod2();
				}
			}
		}
	}

}
