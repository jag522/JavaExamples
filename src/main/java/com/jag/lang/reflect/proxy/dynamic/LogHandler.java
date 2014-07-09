package com.jag.lang.reflect.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	private Object target;

	// public LogHandler() {};

	public LogHandler(Object target) {
		this.target = target;
	}

	// 封装在内部
	// public Object proxy(Object target) {
	// this.target = target;
	// return Proxy.newProxyInstance(target.getClass().getClassLoader(),
	// target.getClass().getInterfaces(), this);
	// }

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		this.doBefore();
		Object result = method.invoke(target, args);
		this.doAfter();
		return result;
	}

	private void doBefore() {
		System.out.println("before...");
	}

	private void doAfter() {
		System.out.println("after...");
	}

}
