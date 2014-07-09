package com.jag.lang;

public class StringCompareToTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "2013-03-04 14:13:50";
		String s2 = "2013-03-05 10:28:53.128";
        if (s1.compareTo(s2) > 0) {
            System.out.println("s1 is greater than s2");
        } else {
        	System.out.println("small");
        }
	}

}
