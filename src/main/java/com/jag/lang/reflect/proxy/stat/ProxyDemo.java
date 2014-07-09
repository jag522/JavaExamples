package com.jag.lang.reflect.proxy.stat;

import com.jag.lang.reflect.proxy.HelloImpl;
import com.jag.lang.reflect.proxy.IHello;

public class ProxyDemo {

	public static void main(String[] args) {
		IHello target = new HelloImpl();
		IHello proxy = new LogHandler(target);
		proxy.sayHello("jag");
	}

}
