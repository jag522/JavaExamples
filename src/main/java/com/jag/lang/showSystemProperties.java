package com.jag.lang;

import java.util.Properties;
import java.util.Set;

public class showSystemProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties ps = System.getProperties();
		Set<Object> s = ps.keySet();
		for(Object key : s) {
			System.out.println(key + ":" + ps.getProperty(key.toString()));
		}
	}

}
