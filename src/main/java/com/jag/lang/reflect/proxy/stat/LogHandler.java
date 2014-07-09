package com.jag.lang.reflect.proxy.stat;

import com.jag.lang.reflect.proxy.IHello;

/**
 * ¾²Ì¬´úÀí
 * @author jag522
 *
 */
public class LogHandler implements IHello {

	IHello target;
	
	public LogHandler(IHello target) {
		this.target = target;
	}
	
	public void sayHello(String s) {
		doBefore();
		target.sayHello(s);
		doAfter();
	}
	
	private void doBefore() {
		System.out.println("before...");
	}
	
	private void doAfter() {
		System.out.println("after...");
	}
	
}
