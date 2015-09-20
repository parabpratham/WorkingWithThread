package com.org.common.thread;

public class WaitNotify {

	class Chat {
		boolean flag = false;

		public synchronized void Question(String msg) {
			if (flag) {
				try {
					wait();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			System.out.println(msg);
			flag = true;
			notify();
		}

		public synchronized void Answer(String msg) {
			if (!flag) {
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			System.out.println(msg);
			flag = false;
			notify();
		}
	}

	class T1 implements Runnable {
		Chat m;
		String[] s1 = { "Hi", "How r u?", "I m also fine" };

		public T1(Chat m1) {
			this.m = m1;
			new Thread(this, "Question").start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (String msg : s1) {
				m.Question(msg);
			}

		}
	}

	class T2 implements Runnable {
		Chat m;
		String[] s2 = { "Hi", "I m good", "Great" };

		public T2(Chat m1) {
			this.m = m1;
			new Thread(this, "Question").start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (String msg : s2) {
				m.Answer(msg);
			}

		}
	}

	public static void main(String[] args) {
		WaitNotify wn = new WaitNotify();
		Chat m = wn.new Chat();
		wn.new T1(m);
		wn.new T2(m);
	}
}
