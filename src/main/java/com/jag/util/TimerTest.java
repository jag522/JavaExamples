package com.jag.util;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	public static void main(String[] args) throws Exception {
		new Timer().schedule(new TimerTask() {
			int i = 1;

			public void run() {
				System.out.println("byebye");
				if (i++ == 5) {
					this.cancel();
					System.exit(0);
				}
			}
		}, 2000, 1000);
		Thread.sleep(5000);
	}
}
