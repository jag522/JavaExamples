package com.jag.lang;

public class IntegerEqualTest {

	public static void main(String[] args) {
		Integer i = new Integer(1);
		if (i == 1) {
			System.out.println("hi1");
		}
		if (i.equals(1)) {
			System.out.println("hi2");
		}
	}

}
