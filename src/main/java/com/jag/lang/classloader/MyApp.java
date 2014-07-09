package com.jag.lang.classloader;

public class MyApp {
	public static void main(String[] args) throws Exception {
		FileClassLoader loader = new FileClassLoader();
		Class objClass = loader.findClass("je3.lang.classloader.MyApp");
		Object obj = objClass.newInstance();
		System.out.println(objClass.getName());
		System.out.println(objClass.getClassLoader());
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(obj);

		MyApp myApp = new MyApp();
		ClassLoader loader2 = myApp.getClass().getClassLoader();
		System.out.println(loader2);
	}
}
