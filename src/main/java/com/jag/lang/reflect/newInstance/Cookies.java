package com.jag.lang.reflect.newInstance;

/**
 * This is the part of the Cookies application that loads the user-defined
 * subclass.
 */
public class Cookies {

	public static void main(String[] argv) {
		System.out.println("Cookies Application Version 0.0");
		Cooklet cooklet = null;
		String cookletClassName = "je3.lang.reflect.newInstance.DemoCooklet";
		try {
			Class cookletClass = Class.forName(cookletClassName);
			Object cookletObject = cookletClass.newInstance();
			cooklet = (Cooklet) cookletObject;
		} catch (Exception e) {
			System.err.println("Error " + cookletClassName + e);
		}
		cooklet.initialize();
		cooklet.work();
		cooklet.terminate();
	}
}
