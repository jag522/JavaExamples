package com.jag.util.concurrency;

public class ClassSync {
	
	public void method() {
		synchronized (ClassSync.class) { // �༶���ϵ�ͬ��
			// synchronized code
		}
	}
}
