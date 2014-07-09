package com.jag.lang.reflect.proxy;

public class HelloImpl implements IHello {
	
	public void sayHello(String s) {
		System.out.println("hello," + s);
	}

}
