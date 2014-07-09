package com.jag.lang.reflect;

import java.util.*;

/**
 * we can get the Class object for any class known at compile time
 */
public class ClassKeyword {
	public static void main(String[] argv) {
		System.out.println(Object.class); // æ≤Ã¨»°µ√¿‡
		System.out.println(String.class);
		System.out.println(String[].class);
		System.out.println(Calendar.class);
		System.out.println(ClassKeyword.class);
		System.out.println(int.class);

		System.out.println();

		System.out.println("Robin the Fearless".getClass());
		System.out.println(Calendar.getInstance().getClass());
	}
}
