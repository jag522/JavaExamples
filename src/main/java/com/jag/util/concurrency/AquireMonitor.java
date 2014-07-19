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
							// Ϊ�˲���,��notify��������ִ�и��̣߳��Ƿ����Ҫ�Ȼ��������ʹ�ڴ˴�û���κδ��룩������δ�ɹ���
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
