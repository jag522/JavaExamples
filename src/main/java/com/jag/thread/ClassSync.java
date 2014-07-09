package com.jag.thread;

public class ClassSync {
	
	public void method() {
		synchronized (ClassSync.class) { // 类级别上的同步
			// synchronized code
		}
	}
}
