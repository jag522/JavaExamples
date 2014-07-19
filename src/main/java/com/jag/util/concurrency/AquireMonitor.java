package com.jag.util.concurrency;

class SharedResource {
}

public class AquireMonitor {

	public static void main(String[] args) {
		final SharedResource sr = new SharedResource();

		new Thread() {
			public void run() {
				while (true) {
					synchronized (sr) {
						try {
							System.out.println("I'm waiting");
							sr.wait();
							// 为了测试,被notify后，若继续执行该线程，是否必须要先获得锁（即使在此处没有任何代码）。测试未成功。
						} catch (Exception e) {
						}
					}
					System.out.println("I've been notified, exit");
					System.exit(0);
				}
			}
		}.start();

		new Thread() {
			public void run() {
				synchronized (sr) {
					try {
						System.out.println("sleep for awhile 1...");
						sleep(2000);
					} catch (Exception e) {
					}
				}
			}
		}.start();

		final Thread t = new Thread() {
			public void run() {
				while (true) {
					synchronized (sr) {
						System.out.println("I'm ready to notify him");
						sr.notify();
						break;
					}
				}
			}
		};
		

		new Thread() {
			public void run() {
				try {
					t.join();
				} catch (InterruptedException e) {
				}
				synchronized (sr) {
					try {
						System.out.println("sleep for awhile 2...");
						sleep(2000);
					} catch (Exception e) {
					}
				}
			}
		}.start();

		t.start();
		
	}

}
