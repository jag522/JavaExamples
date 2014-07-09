package com.jag.other;

import java.util.Enumeration;
import java.util.Properties;

public class SystemProperties {

	public static void main(String[] args) {
		Properties p = System.getProperties();
		Enumeration e = p.keys();
		String key, value;
		while (e.hasMoreElements()) {
			key = (String) e.nextElement();
			value = p.getProperty(key);
			System.out.println(key + "(" + value + ")");
		}
	}

}
