package com.jag.lang.classloader2;

public class WhichClassLoader2 {

	// This method is invoked from WhichClassLoader1
	public void getTheClass() {
		WhichClassLoader3 wcl3 = new WhichClassLoader3();
		System.out.println("WCL3 was loaded by "
				+ wcl3.getClass().getClassLoader());
	}
}