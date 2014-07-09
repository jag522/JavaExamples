package com.jag.lang.reflect;

import java.lang.reflect.*;

import java.util.*;

/** This class shows using Reflection to get a field from another class. */

public class FindField {

	public static void main(String[] unused) throws NoSuchFieldException, IllegalAccessException {
		// Create instance of target class (YearHolder defined below).
		Object o = new YearHolder();
		Class c = o.getClass();
		Field fld = c.getField("fieldCurrentYear");
		int value = fld.getInt(o);
		System.out.println(value);
	}
}

/** This is just a class that we want to get a field from */
class YearHolder {
	/** Just a field that is used to show getting a field's value. */
	public int fieldCurrentYear = Calendar.getInstance().get(Calendar.YEAR);
}
